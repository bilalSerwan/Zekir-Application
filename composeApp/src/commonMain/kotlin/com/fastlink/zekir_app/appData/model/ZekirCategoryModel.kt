package com.fastlink.zekir_app.appData.model

import androidx.compose.runtime.Stable

@Stable
data class ZekirCategoryModel(
    val id: Int=0,
    val zekirCategoryTitle: String="",
    val plainZekirCategoryTitle: String="",
    var isFavorite: Boolean = false
)