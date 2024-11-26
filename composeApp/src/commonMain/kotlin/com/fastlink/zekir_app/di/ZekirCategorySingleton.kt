package com.fastlink.zekir_app.di

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.fastlink.zekir_app.appData.model.ZekirCategoryModel
import com.fastlink.zekir_app.appData.zekirCategoryData


object ZekirCategorySingleton {
    private val _zekirCategoriesData = mutableStateOf<List<ZekirCategoryModel>>(emptyList())
    val zekirCategoriesData: State<List<ZekirCategoryModel>>
        get() = _zekirCategoriesData

    init {
        addZekirCategories()
    }

    fun getCategoryById(categoryId: Int) = _zekirCategoriesData.value.first { it.id == categoryId }

    fun getFavoriteCategories(): List<ZekirCategoryModel> =
        _zekirCategoriesData.value.filter { it.isFavorite }

    fun updateCategory(categoryId: Int, isFavorite: Boolean) {
        _zekirCategoriesData.value = _zekirCategoriesData.value.map { category ->
            if (category.id == categoryId) {
                category.copy(isFavorite = isFavorite)
            } else {
                category
            }
        }
    }

    private fun addZekirCategories() {
        for (zekirCategory in zekirCategoryData) {
            _zekirCategoriesData.value += zekirCategory
        }
    }

}
