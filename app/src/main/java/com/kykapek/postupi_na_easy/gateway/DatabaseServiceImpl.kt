package com.kykapek.postupi_na_easy.gateway

import com.kykapek.postupi_na_easy.repository.Olymp

// Запросы в бд (выполнение)
class DatabaseServiceImpl : DatabaseService {
    //val source = FirebaseDatabase.getInstance().reference
    override fun getOlympsByKey(key: String): List<Olymp> {
        // souce..onData... в зависисмости от key!! что ввел юзер
        return (1..100).map { it.toString() }.map { Olymp(it, it) }
    }
}