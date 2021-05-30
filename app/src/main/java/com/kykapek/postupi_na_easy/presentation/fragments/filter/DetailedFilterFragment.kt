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
        args.buttonsSet.forEach {
            val button = layoutInflater.inflate(
                R.layout.view_blue_button,
                container,
                false
            ) as MaterialButton
            button.text = it
            button.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_history)
            container.addView(button)
        }
    }
}