package com.manudev.dreamtv.presentation.categories


import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.leanback.widget.*
import com.manudev.dreamtv.CardPresenter
import com.manudev.dreamtv.Movie

/**
 * A simple [Fragment] subclass.
 */
class CategoriesFragment : VerticalGridSupportFragment() {

    companion object {
        private const val COLUMNS = 3
        private const val ZOOM_FACTOR = FocusHighlight.ZOOM_FACTOR_MEDIUM
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Title"
        setupRowAdapter()

        onItemViewClickedListener = ItemViewClickedListener()
    }

    private fun setupRowAdapter() {
        val gridPresenter = VerticalGridPresenter(ZOOM_FACTOR)
        gridPresenter.numberOfColumns = COLUMNS
        setGridPresenter(gridPresenter)

        val cardPresenterSelector = CardPresenter()
        val mAdapter = ArrayObjectAdapter(cardPresenterSelector)
        adapter = mAdapter

    }

    inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder, item: Any,
            rowViewHolder: RowPresenter.ViewHolder, row: Row
        ) {

            if (item is Movie) {
                val card = item

//                val intent = Intent(activity, VideoDetailsActivity::class.java)
//                intent.putExtra(INTENT_TASK, task)
//                intent.putExtra(INTENT_CATEGORY, card.getCategory())
//
//                startActivity(intent)

            } else
                Toast.makeText(activity, "", Toast.LENGTH_SHORT).show()

        }
    }
}
