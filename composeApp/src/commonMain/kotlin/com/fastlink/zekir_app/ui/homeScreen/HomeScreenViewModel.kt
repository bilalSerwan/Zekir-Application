package com.fastlink.zekir_app.ui.homeScreen

import androidx.lifecycle.ViewModel
import com.fastlink.zekir_app.di.ZekirCategorySingleton
import com.fastlink.zekir_app.appData.model.ZekirCategoryModel

class HomeScreenViewModel : ViewModel() {

    fun getAllZekirCategories(): List<ZekirCategoryModel> =
        ZekirCategorySingleton.zekirCategoriesData.value

    fun updateZekirCategory(categoryId: Int, isFavorite: Boolean) =
        ZekirCategorySingleton.updateCategory(categoryId, isFavorite)
}