package com.kykapek.postupi_na_easy.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.firsovam.postupi_na_easy.R
import com.kykapek.postupi_na_easy.presentation.OlympAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private val viewModelFactory by lazy {
        ViewModelProvider.NewInstanceFactory()
    }

    private val homeViewModel by lazy {
        viewModelFactory.create(HomeViewModel::class.java)
    }

    private val adapter = OlympAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.adapter = adapter

        with(homeViewModel) {
            olympsLiveData.observe(viewLifecycleOwner) {
                adapter.update(it.toMutableList())
            }
            getOlympsByKey(key = "yui")
        }

        btnFilter.setOnClickListener {
            findNavController().navigate(R.id.toFilter)
        }

        /**
         * Спасить как можно больше данных, сверстать фильтры по аналогии и реализовать выдачу данных по key в DatabaseService
         * [com.kykapek.postupi_na_easy.gateway.DatabaseService.getOlympsByKey]
         */

        /**
         * Иконки  - олимпиада, баллы, и тп + . По АНАЛогии с этим фграментом сделавть кнопку и заголовок в вложенном
         */
    }
}