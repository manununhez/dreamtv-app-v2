package com.manudev.dreamtv.presentation.search


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.leanback.app.SearchSupportFragment
import androidx.leanback.widget.ObjectAdapter
import com.manudev.dreamtv.R

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : SearchSupportFragment(), SearchSupportFragment.SearchResultProvider {
    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getResultsAdapter(): ObjectAdapter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onQueryTextChange(newQuery: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
