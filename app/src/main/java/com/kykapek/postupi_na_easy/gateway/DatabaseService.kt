package com.kykapek.postupi_na_easy.gateway

import com.kykapek.postupi_na_easy.repository.models.Olymp

// Запросы в бд
interface DatabaseService {
    suspend fun getOlympsByKey(key: String): List<Olymp>
}