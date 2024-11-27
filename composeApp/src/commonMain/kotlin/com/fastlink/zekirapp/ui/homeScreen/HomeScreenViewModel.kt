package com.fastlink.zekirapp.ui.homeScreen

import androidx.lifecycle.ViewModel
import com.fastlink.zekirapp.di.ZekirCategorySingleton
import com.fastlink.zekirapp.appData.model.ZekirCategoryModel

class HomeScreenViewModel : ViewModel() {

    fun getAllZekirCategories(): List<ZekirCategoryModel> =
        ZekirCategorySingleton.zekirCategoriesData.value

    fun updateZekirCategory(categoryId: Int, isFavorite: Boolean) =
        ZekirCategorySingleton.updateCategory(categoryId, isFavorite)
}