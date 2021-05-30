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
            findNavController().navigate(
                FilterFragmentDirections.toDetailedFilter(
                    "Олимпиады", arrayOf("Предметы", "Уровень олиимпиады", "Класс")
                )
            )
        }
        btn_choose_program.setOnClickListener {
            findNavController().navigate(
                FilterFragmentDirections.toDetailedFilter(
                    "Программы обучения",
                    arrayOf("Направления", "Предметы ЕГЭ", "Баллы ЕГЭ", "Город", "ВУЗ")
                )
            )
        }
        btn_choose_tasks.setOnClickListener {
            findNavController().navigate(
                FilterFragmentDirections.toDetailedFilter(
                    "Задания ЕГЭ", arrayOf("Предмет", "Номер задания")
                )
            )
        }
    }
}