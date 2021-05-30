package com.kykapek.postupi_na_easy.repository

import com.kykapek.postupi_na_easy.repository.models.Olymp

interface DatabaseRepository {
    // Выдача по запросу
    suspend fun getOlympsByKey(key: String): List<Olymp>
}