/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.manudev.dreamtv.presentation.details

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.app.DetailsSupportFragmentBackgroundController
import androidx.leanback.widget.*
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.manudev.dreamtv.CardPresenter
import com.manudev.dreamtv.Movie
import com.manudev.dreamtv.MovieList
import com.manudev.dreamtv.R

/**
 * A wrapper fragment for leanback details screens.
 * It shows a detailed view of video and its metadata plus related videos.
 */
class VideoDetailsFragment : DetailsSupportFragment() {


    private var mSelectedMovie: Movie? = null

    private lateinit var mDetailsBackground: DetailsSupportFragmentBackgroundController
    private lateinit var mPresenterSelector: ClassPresenterSelector
    private lateinit var mAdapter: ArrayObjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDetailsBackground = DetailsSupportFragmentBackgroundController(this)


        arguments?.let {
            val safeArgs = VideoDetailsFragmentArgs.fromBundle(it)
            mSelectedMovie = safeArgs.movie
        }


        mSelectedMovie ?: findNavController().popBackStack() //Go back to home if movie is null


        mPresenterSelector = ClassPresenterSelector()
        mAdapter = ArrayObjectAdapter(mPresenterSelector)
        setupDetailsOverviewRow()
        setupDetailsOverviewRowPresenter()
        setupRelatedMovieListRow()
        adapter = mAdapter
        initializeBackground(mSelectedMovie)
        onItemViewClickedListener = ItemViewClickedListener()

    }

    private fun initializeBackground(movie: Movie?) {
        mDetailsBackground.enableParallax()

        val options = RequestOptions()
            .centerInside()
            .error(R.drawable.default_background)

        Glide.with(requireContext())
            .asBitmap()
            .load(movie?.backgroundImageUrl)
            .apply(options)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    mDetailsBackground.coverBitmap = resource
                    mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size())
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
                }
            })

    }


    private fun setupDetailsOverviewRow() {
        Log.d(TAG, "doInBackground: " + mSelectedMovie?.toString())
        val row = DetailsOverviewRow(mSelectedMovie)

        val options = RequestOptions()
            .error(R.drawable.default_background)
            .dontAnimate()
            .centerCrop()


        Glide.with(requireContext())
            .asBitmap()
            .load(mSelectedMovie?.cardImageUrl)
            .apply(options)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    row.setImageBitmap(context!!, resource)
                    startEntranceTransition()
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
                }
            })

        val actionAdapter = ArrayObjectAdapter()

        actionAdapter.add(
            Action(
                ACTION_WATCH_TRAILER,
                getString(R.string.watch_trailer_1),
                getString(R.string.watch_trailer_2)
            )
        )
        actionAdapter.add(
            Action(
                ACTION_RENT,
                getString(R.string.rent_1),
                getString(R.string.rent_2)
            )
        )
        actionAdapter.add(
            Action(
                ACTION_BUY,
                getString(R.string.buy_1),
                getString(R.string.buy_2)
            )
        )
        row.actionsAdapter = actionAdapter

        mAdapter.add(row)
    }

    private fun setupDetailsOverviewRowPresenter() {
        // Set detail background.
        val detailsPresenter = FullWidthDetailsOverviewRowPresenter(DetailsDescriptionPresenter())
        detailsPresenter.backgroundColor =
            ContextCompat.getColor(requireActivity(), R.color.selected_background)

        // Hook up transition element.
        val sharedElementHelper = FullWidthDetailsOverviewSharedElementHelper()
        sharedElementHelper.setSharedElementEnterTransition(
            activity, SHARED_ELEMENT_NAME
        )
        detailsPresenter.setListener(sharedElementHelper)
        detailsPresenter.isParticipatingEntranceTransition = true

        detailsPresenter.onActionClickedListener = OnActionClickedListener { action ->
            if (action.id == ACTION_WATCH_TRAILER) {
                findNavController().navigate(
                    VideoDetailsFragmentDirections.actionVideoDetailsFragmentToPlaybackVideoFragment(
                        mSelectedMovie!!
                    )
                )
            } else {
                Toast.makeText(requireActivity(), action.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        mPresenterSelector.addClassPresenter(DetailsOverviewRow::class.java, detailsPresenter)
    }

    private fun setupRelatedMovieListRow() {
        val subcategories = arrayOf(getString(R.string.related_movies))
        val list = MovieList.list.toMutableList()

        list.shuffle()

        val listRowAdapter = ArrayObjectAdapter(CardPresenter())
        for (j in 0 until NUM_COLS) {
            listRowAdapter.add(list[j % 5])
        }

        val header = HeaderItem(0, subcategories[0])
        mAdapter.add(ListRow(header, listRowAdapter))
        mPresenterSelector.addClassPresenter(ListRow::class.java, ListRowPresenter())
    }

    private inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder,
            row: Row
        ) {
            if (item is Movie) {
                ViewCompat.setTransitionName(
                    (itemViewHolder.view as ImageCardView).mainImageView,
                    SHARED_ELEMENT_NAME
                )

                val extras = FragmentNavigatorExtras(
                    (itemViewHolder.view as ImageCardView).mainImageView to SHARED_ELEMENT_NAME
                )
                //related videos
                findNavController().navigate(
                    VideoDetailsFragmentDirections.actionVideoDetailsFragmentRelatedVideos(item), extras
                )

            }
        }
    }

    companion object {
        private const val TAG = "VideoDetailsFragment"

        private const val ACTION_WATCH_TRAILER = 1L
        private const val ACTION_RENT = 2L
        private const val ACTION_BUY = 3L

        private const val NUM_COLS = 10

        const val SHARED_ELEMENT_NAME = "hero"
        const val MOVIE = "Movie"
    }
}