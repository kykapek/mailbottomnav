package com.kykapek.postupi_na_easy.repository

import android.content.Context
import com.kykapek.postupi_na_easy.presentation.activities.MenuActivity
import com.kykapek.postupi_na_easy.repository.models.Olymp

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

    override suspend fun getOlympsByKey(key: String): List<Olymp> {
        return database.getOlympsByKey(key)
    }

}