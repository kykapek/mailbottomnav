package com.kykapek.postupi_na_easy.repository.models

fun Char.arabicCharToInt() = when (this) {
    'Ⅱ' -> 2
    'Ⅲ' -> 3
    'Ⅰ' -> 1
    else -> 0
}