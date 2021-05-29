package com.kykapek.postupi_na_easy.presentation.fragments.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.firsovam.postupi_na_easy.R
import kotlinx.android.synthetic.main.fragment_filter.*

class FilterFragment : Fragment() {

    companion object {
        var mInstance: FilterFragment? = null

        @JvmStatic
        fun getInstance(): FilterFragment {
            return mInstance ?: FilterFragment().also { mInstance = it }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_main_search_back.setOnClickListener {
            findNavController().popBackStack()
        }
        btn_choose_olymp.setOnClickListener {
            findNavController().navigate(R.id.toFilterOlympMain)
        }
    }
}