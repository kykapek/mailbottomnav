package com.kykapek.postupi_na_easy.presentation

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import com.firsovam.postupi_na_easy.R
import com.kykapek.postupi_na_easy.repository.models.Olymp
import com.kykapek.postupi_na_easy.repository.models.arabicCharToInt
import kotlinx.android.synthetic.main.fragment_filter_olymp_main.view.*
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
        val linkozavr = item.link
        val stringSubjects = item.subjects
        println(linkozavr)
        println(item.name)
        println(stringSubjects)
        setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkozavr))
            context.startActivity(intent)
        }
        val lstValues: List<String> = stringSubjects.split(",").map { it -> it.trim() }
        containerSubjectsIcons.removeAllViews()
        lstValues.forEach { it ->
            Log.i("Values", "value=$it")
            val layoutInflater = LayoutInflater.from(context)
            var iconSelect = when (it) {
                "математика" -> R.drawable.ic_math
                "астрономия" -> R.drawable.ic_astronomy
                "обществознание" -> R.drawable.ic_social
                "биология" -> R.drawable.ic_biology
                "география" -> R.drawable.ic_geography
                "химия" -> R.drawable.ic_chemistry
                "история" -> R.drawable.ic_history
                "информатика" -> R.drawable.ic_informatics
                "английский" -> R.drawable.ic_language
                "испанский" -> R.drawable.ic_language
                "французский" -> R.drawable.ic_language
                "китайский" -> R.drawable.ic_china
                "английский язык" -> R.drawable.ic_language
                "испанский язык" -> R.drawable.ic_language
                "французский язык" -> R.drawable.ic_language
                "китайский язык" -> R.drawable.ic_china
                "иностранный язык" -> R.drawable.ic_language
                "литература" -> R.drawable.ic_literature
                "музыка" -> R.drawable.ic_music
                "сольфеджио" -> R.drawable.ic_music
                "живопись" -> R.drawable.ic_painting
                "рисунок" -> R.drawable.ic_risunok_2
                "искусство (МХК)" -> R.drawable.ic_art_mhk
                "композиция" -> R.drawable.ic_compisition
                "черчение" -> R.drawable.ic_drafting
                "физкультура" -> R.drawable.ic_pe
                "физика" -> R.drawable.ic_physics
                "русский язык" -> R.drawable.ic_russian
                "право" -> R.drawable.ic_law
                "музыкальная литература" -> R.drawable.ic_music_lit
                else -> R.drawable.ic_scores
            }
            if (iconSelect != R.drawable.ic_scores) {
                val iconSubject = layoutInflater.inflate(
                    R.layout.view_subject_icons,
                    container,
                    false,

                    ) as ImageView
                containerSubjectsIcons.addView(iconSubject)
                var iconColor = when (it) {
                    "математика" -> R.color.gray_card
                    "астрономия" -> R.color.purple_700
                    "обществознание" -> R.color.blue
                    "биология" -> R.color.green
                    "география" -> R.color.dark_green
                    "химия" -> R.color.yellow_ch
                    "история" -> R.color.orange_hist
                    "информатика" -> R.color.black
                    "английский" -> R.color.blue_secondary
                    "испанский" -> R.color.brown
                    "французский" -> R.color.blue
                    "китайский" -> R.color.orange_hist
                    "английский язык" -> R.color.blue_secondary
                    "испанский язык" -> R.color.brown
                    "французский язык" -> R.color.blue
                    "китайский язык" -> R.color.orange_hist
                    "иностранный язык" -> R.color.blue_secondary
                    "литература" -> R.color.red
                    "музыка" -> R.color.black
                    "сольфеджио" -> R.color.black
                    "живопись" -> R.color.green_canvas
                    "черчение" -> R.color.gray_card
                    "композиция" -> R.color.black
                    "рисунок" -> R.color.brown
                    "искусство (МХК)" -> R.color.gray_card
                    "физкультура" -> R.color.black
                    "физика" -> R.color.black
                    "русский язык" -> R.color.gray_card
                    "право" -> R.color.orange_hist
                    "музыкальная литература" -> R.color.purple_500
                    else -> R.color.blue_secondary
                }
                iconSubject.setColorFilter(
                    ContextCompat.getColor(context, iconColor),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

                iconSubject.setImageResource(iconSelect)
            }

            /*if(it == "обществознание") {
                val layoutInflater = LayoutInflater.from(context)
                val iconSubject = layoutInflater.inflate(
                    R.layout.view_subject_icons,
                    container,
                    false,

                    ) as ImageView
                containerSubjectsIcons.addView(iconSubject)
                iconSubject.setImageResource(R.drawable.ic_social)
            }
            if(it == "математика") {
                val layoutInflater = LayoutInflater.from(context)
                val iconSubject = layoutInflater.inflate(
                    R.layout.view_subject_icons,
                    container,
                    false,

                    ) as ImageView
                containerSubjectsIcons.addView(iconSubject)
                var ima = R.drawable.ic_math
                iconSubject.setImageResource(ima)
            }
            if(it == "история") {
                val layoutInflater = LayoutInflater.from(context)
                val iconSubject = layoutInflater.inflate(
                    R.layout.view_subject_icons,
                    container,
                    false,

                    ) as ImageView
                containerSubjectsIcons.addView(iconSubject)
                iconSubject.setImageResource(R.drawable.ic_history)
            }
            if(it == "физика") {
                val layoutInflater = LayoutInflater.from(context)
                val iconSubject = layoutInflater.inflate(
                    R.layout.view_subject_icons,
                    container,
                    false,

                    ) as ImageView
                containerSubjectsIcons.addView(iconSubject)
                iconSubject.setImageResource(R.drawable.ic_physics)
            }
            if(it == "информатика") {
                val layoutInflater = LayoutInflater.from(context)
                val iconSubject = layoutInflater.inflate(
                    R.layout.view_subject_icons,
                    container,
                    false,

                    ) as ImageView
                containerSubjectsIcons.addView(iconSubject)
                iconSubject.setImageResource(R.drawable.ic_informatics)
            }
            if(it == "биология") {
                val layoutInflater = LayoutInflater.from(context)
                val iconSubject = layoutInflater.inflate(
                    R.layout.view_subject_icons,
                    container,
                    false,

                    ) as ImageView
                containerSubjectsIcons.addView(iconSubject)
                iconSubject.setImageResource(R.drawable.ic_biology)
            }*/
            //Do Something
        }
        //println(stringSubjects)

        /*val layoutInflater = LayoutInflater.from(context)
        val iconSubject = layoutInflater.inflate(
            R.layout.view_subject_icons,
            container,
            false,

            ) as ImageView
        containerSubjectsIcons.addView(iconSubject)
        iconSubject.setImageResource(R.drawable.ic_math)*/

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

        //tvLevel.text = "Уровень: $level"
    }
}