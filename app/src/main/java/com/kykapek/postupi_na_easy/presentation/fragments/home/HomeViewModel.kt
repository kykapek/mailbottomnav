package com.kykapek.postupi_na_easy.presentation.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kykapek.postupi_na_easy.repository.GetOlympsByKeyUseCase
import com.kykapek.postupi_na_easy.repository.models.Olymp

class HomeViewModel : ViewModel() {
    /**
     * UseCases
     */
    private val getOlympsByKeyUseCase by lazy {
        GetOlympsByKeyUseCase()
    }

    /**
     * LiveData
     */
    val olympsLiveData: MutableLiveData<List<Olymp>> by lazy {
        MutableLiveData<List<Olymp>>()
    }
    val isLoadingLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    // ui -> viewModel -> useCase -> repo -> source
    // ui <- liveData <- onComplete <- useCase <- repo <- source
    fun getOlympsByKey(key: String) {
        getOlympsByKeyUseCase.apply {
            this.key = key
        }.execute {
            onError {

            }
            onStart {
                isLoadingLiveData.value = true
            }
            onStop {
                isLoadingLiveData.value = false
            }
            onComplete {
                // здесь мы уже получили данные от репо
                olympsLiveData.value = it
            }
        }
    }
}