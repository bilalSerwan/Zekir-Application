package com.fastlink.zekrapp.ui.favoriteScreen

import androidx.lifecycle.ViewModel
import com.fastlink.zekir_app.di.ZekirCategorySingleton
import com.fastlink.zekir_app.appData.model.ZekirCategoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteScreenViewModel @Inject constructor() :
    ViewModel(){

    fun getFavoriteZekirCategories(): List<ZekirCategoryModel> =
        ZekirCategorySingleton.getFavoriteCategories()

    fun updateZekirCategory(categoryId: Int, isFavorite: Boolean) =
        ZekirCategorySingleton.updateCategory(categoryId, isFavorite)
}