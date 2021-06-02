package com.kykapek.postupi_na_easy.presentation.fragments.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.firsovam.postupi_na_easy.R
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_filter_olymp_main.*

class DetailedFilterFragment : Fragment() {

    val args by navArgs<DetailedFilterFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter_olymp_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_main_to_search_back.setOnClickListener {
            findNavController().popBackStack()
        }
        tvHeader.text = args.header
        if (tvHeader.text == "Олимпиады") {
            var i = 1
            args.buttonsSet.forEach {
                val button = layoutInflater.inflate(
                    R.layout.view_blue_button,
                    container,
                    false
                ) as MaterialButton
                button.text = it
                if (i == 1) {
                    button.icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_subjects)
                    container.addView(button)
                }
                if (i == 2) {
                    button.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_level)
                    container.addView(button)
                }
                if (i == 3) {
                    button.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_class)
                    container.addView(button)
                }
                i++
            }
        }
        if (tvHeader.text == "Программы обучения") {
            var i = 1
            args.buttonsSet.forEach {
                val button = layoutInflater.inflate(
                    R.layout.view_blue_button,
                    container,
                    false
                ) as MaterialButton
                button.text = it
                if (i == 1) {
                    button.icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_directions)
                    container.addView(button)
                }
                if (i == 2) {
                    button.icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_subjects)
                    container.addView(button)
                }
                if (i == 3) {
                    button.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_scores)
                    container.addView(button)
                }
                if (i == 4) {
                    button.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_city)
                    container.addView(button)
                }
                if (i == 5) {
                    button.icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_university)
                    container.addView(button)
                }
                i++
            }
        }
        if (tvHeader.text == "Задания ЕГЭ") {
            var i = 1
            args.buttonsSet.forEach {
                val button = layoutInflater.inflate(
                    R.layout.view_blue_button,
                    container,
                    false
                ) as MaterialButton
                button.text = it
                if (i == 1) {
                    button.icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_subjects)
                    container.addView(button)
                }
                if (i == 2) {
                    button.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_numbers)
                    container.addView(button)
                }
                i++
            }
        }
    }
}