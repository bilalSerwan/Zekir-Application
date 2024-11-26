package com.fastlink.zekir_app.di

import androidx.lifecycle.SavedStateHandle
import com.fastlink.zekir_app.ui.favoriteScreen.FavoriteScreenViewModel
import com.fastlink.zekir_app.ui.homeScreen.HomeScreenViewModel
import com.fastlink.zekir_app.ui.zekirScreen.ZekirScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        FavoriteScreenViewModel()
    }
    viewModel { (savedStateHandle: SavedStateHandle) ->
        ZekirScreenViewModel(savedStateHandle = savedStateHandle)
    }
    viewModel {
        HomeScreenViewModel()
    }
}