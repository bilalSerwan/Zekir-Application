package com.fastlink.zekirapp.ui.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fastlink.zekirapp.ui.utils.AppBar
import com.fastlink.zekirapp.ui.utils.ZekirCategoryCard
import com.fastlink.zekirapp.ui.utils.bottomAppBar.BottomBar
import com.fastlink.zekirapp.ui.utils.bottomAppBar.getListOfBottomBarItems
import com.fastlink.zekirapp.ui.utils.spacing
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import zekirapp.composeapp.generated.resources.Favorite
import zekirapp.composeapp.generated.resources.Home
import zekirapp.composeapp.generated.resources.HomeAppBarTitle
import zekirapp.composeapp.generated.resources.Res

@Composable
fun HomeScreen(
    navController: NavController,
    homeScreenViewModel: HomeScreenViewModel = koinViewModel(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(backgroundColor = MaterialTheme.colorScheme.background,
        topBar = { AppBar(title = stringResource(resource = Res.string.HomeAppBarTitle)) },
        bottomBar = {
            navBackStackEntry?.let { entry ->
                BottomBar(
                    bottomBarItems = getListOfBottomBarItems(
                        homeIconLabel = stringResource(resource = Res.string.Home),
                        favoriteIconLabel = stringResource(resource = Res.string.Favorite),
                        navController = navController,
                        navBackStackEntry = entry
                    )
                )
            }
        }) {
        Box(
            modifier = Modifier
                .padding(it)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {
                items(
                    homeScreenViewModel.getAllZekirCategories(),
                    key = { zekir -> zekir.id }
                ) { zekirCategory ->
                    ZekirCategoryCard(
                        zekirCategory = zekirCategory,
                        navController = navController,
                        onFavoriteIconClicked = {
                            homeScreenViewModel.updateZekirCategory(
                                zekirCategory.id,
                                !zekirCategory.isFavorite
                            )
                        }
                    )
                }
                item {
                    Spacer(modifier = Modifier.padding(MaterialTheme.spacing.medium))
                }
            }
        }
    }
}