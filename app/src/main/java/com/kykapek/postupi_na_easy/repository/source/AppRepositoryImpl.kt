package com.kykapek.postupi_na_easy.repository

import android.content.Context
import com.kykapek.postupi_na_easy.presentation.activities.MenuActivity

class AppRepositoryImpl : AppRepository {
    var context: Context? = null

    // Создаем объект бд
    private val database by lazy {
        MenuActivity.database
    }

    // Создаем объект локальной даты
    private val sharedPreferences by lazy {
        context?.getSharedPreferences("1", Context.MODE_PRIVATE)
    }

    override fun getOlympsByKey(key: String): List<Olymp> {
        return database.getOlympsByKey(key)
    }

}