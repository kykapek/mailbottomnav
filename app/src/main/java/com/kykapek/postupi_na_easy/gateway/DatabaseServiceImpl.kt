package com.kykapek.postupi_na_easy.gateway

import com.kykapek.postupi_na_easy.repository.Olymp

// Запросы в бд (выполнение)
class DatabaseServiceImpl : DatabaseService {
    override fun getOlympsByKey(key: String): List<Olymp> {
        return (1..100).map { it.toString() }.map { Olymp(it, it) }
    }
}