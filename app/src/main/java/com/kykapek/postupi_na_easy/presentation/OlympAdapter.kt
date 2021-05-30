package com.kykapek.postupi_na_easy.presentation

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.firsovam.postupi_na_easy.R
import com.kykapek.postupi_na_easy.repository.models.Olymp
import com.kykapek.postupi_na_easy.repository.models.arabicCharToInt
import kotlinx.android.synthetic.main.view_olymp_item.view.*

class OlympAdapter : AbstractListAdapter<Olymp>(
    object : DiffUtil.ItemCallback<Olymp>() {
        override fun areContentsTheSame(oldItem: Olymp, newItem: Olymp): Boolean {
            return false
        }

        override fun areItemsTheSame(oldItem: Olymp, newItem: Olymp): Boolean {
            return false
        }
    }, R.layout.view_olymp_item
) {

    override fun View.onBind(item: Olymp, bindingPosition: Int, itemCount: Int) {
        tvName.text = item.name
        tvSubject.text = item.subjects
        val level = with(item.level) {
            if (isNotEmpty()) {
                if (none { it.arabicCharToInt() == 0 }) {
                    first().arabicCharToInt().toString()
                } else {
                    first().arabicCharToInt().toString() + " - " + this[2].arabicCharToInt()
                        .toString()
                }
            } else {
                "Неизвестен"
            }
        }
        tvLevel.text = "Уровень: $level"
    }
}