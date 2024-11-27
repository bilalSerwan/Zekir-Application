package com.fastlink.zekirapp.ui.favoriteScreen

import androidx.lifecycle.ViewModel
import com.fastlink.zekirapp.di.ZekirCategorySingleton
import com.fastlink.zekirapp.appData.model.ZekirCategoryModel


class FavoriteScreenViewModel  : ViewModel(){

    fun getFavoriteZekirCategories(): List<ZekirCategoryModel> =
        ZekirCategorySingleton.getFavoriteCategories()

    fun updateZekirCategory(categoryId: Int, isFavorite: Boolean) =
        ZekirCategorySingleton.updateCategory(categoryId, isFavorite)
}