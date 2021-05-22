package com.kykapek.postupi_na_easy.repository

interface DatabaseRepository {
    // Выдача по запросу
    fun getOlympsByKey(key: String): List<Olymp>
}