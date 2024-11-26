package com.fastlink.zekir_app.ui.favoriteScreen

import androidx.lifecycle.ViewModel
import com.fastlink.zekir_app.di.ZekirCategorySingleton
import com.fastlink.zekir_app.appData.model.ZekirCategoryModel


class FavoriteScreenViewModel  : ViewModel(){

    fun getFavoriteZekirCategories(): List<ZekirCategoryModel> =
        ZekirCategorySingleton.getFavoriteCategories()

    fun updateZekirCategory(categoryId: Int, isFavorite: Boolean) =
        ZekirCategorySingleton.updateCategory(categoryId, isFavorite)
}