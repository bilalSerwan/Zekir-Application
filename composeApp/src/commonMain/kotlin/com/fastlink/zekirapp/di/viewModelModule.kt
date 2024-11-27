package com.fastlink.zekirapp.di

import androidx.lifecycle.SavedStateHandle
import com.fastlink.zekirapp.ui.favoriteScreen.FavoriteScreenViewModel
import com.fastlink.zekirapp.ui.homeScreen.HomeScreenViewModel
import com.fastlink.zekirapp.ui.zekirScreen.ZekirScreenViewModel
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