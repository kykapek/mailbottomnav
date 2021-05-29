package com.kykapek.postupi_na_easy.presentation.fragments.filter.filterolympmain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.firsovam.postupi_na_easy.R
import kotlinx.android.synthetic.main.fragment_filter_olymp_main.*

class FilterOlympMain : Fragment() {

    companion object {
        var mInstance: FilterOlympMain? = null

        @JvmStatic
        fun getInstance(): FilterOlympMain {
            return mInstance ?: FilterOlympMain().also { mInstance = it }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter_olymp_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_main_search_olymp_back.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}