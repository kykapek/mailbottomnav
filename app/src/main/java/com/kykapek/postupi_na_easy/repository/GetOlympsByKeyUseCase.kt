package com.kykapek.postupi_na_easy.repository

import com.kykapek.postupi_na_easy.presentation.activities.MenuActivity.Companion.appRepository
import kotlin.properties.Delegates

class GetOlympsByKeyUseCase : UseCase<List<Olymp>>() {
    var key: String by Delegates.notNull()
    override suspend fun executeOnBackground(): List<Olymp> {
        return appRepository.getOlympsByKey(key)
    }
}