package com.kykapek.postupi_na_easy.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
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

    /**
     * (1)
     * Сделать кнопку над ресайклером,
     * по нажатию на которую ресайклер будет исчезать (не нужна лайвдата)
     */

    /**
     * (2)
     * Слева от кнопки сделать EditText (поиск), и при каждом изменении текста добавлять
     * в ресайклер три элемента name = "Леха" subject = "Alice"
     * TextWatcher (не нужна лайвдата)
     */

    /**
     * (3)
     * При вводе 0 в поиск, обновить данные для ввода key = "Op",
     * при этом для этого случая сделать очистку, а не обновление ресайклера
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.adapter = adapter

        with(homeViewModel) {
            olympsLiveData.observe(viewLifecycleOwner) {
                adapter.update(it.toMutableList())
            }
            getOlympsByKey(key = "yui")
        }
    }
}