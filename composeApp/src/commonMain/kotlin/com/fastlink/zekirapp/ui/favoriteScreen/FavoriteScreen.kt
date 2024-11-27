package com.fastlink.zekirapp.ui.favoriteScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fastlink.zekirapp.ui.utils.AppBar
import com.fastlink.zekirapp.ui.utils.ZekirCategoryCard
import com.fastlink.zekirapp.ui.utils.bottomAppBar.BottomBar
import com.fastlink.zekirapp.ui.utils.bottomAppBar.getListOfBottomBarItems
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import zekirapp.composeapp.generated.resources.Favorite
import zekirapp.composeapp.generated.resources.FavoriteAppBarTitle
import zekirapp.composeapp.generated.resources.Home
import zekirapp.composeapp.generated.resources.Res

@Composable
fun FavoriteScreen(
    navController: NavController,
    favoriteScreenViewModel: FavoriteScreenViewModel = koinViewModel<FavoriteScreenViewModel>()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            AppBar(
                title = stringResource(
                    resource = Res.string.FavoriteAppBarTitle,
                )
            )
        },
        bottomBar = {
            navBackStackEntry?.let { entry ->
                BottomBar(
                    bottomBarItems = getListOfBottomBarItems(
                        homeIconLabel = stringResource(resource = Res.string.Home),
                        favoriteIconLabel = stringResource(Res.string.Favorite),
                        navController = navController,
                        navBackStackEntry = entry
                    )
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            if (favoriteScreenViewModel.getFavoriteZekirCategories().isEmpty()) {
                Text(
                    text = "No Favorite Categories Yet",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 22.sp,
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    items(favoriteScreenViewModel.getFavoriteZekirCategories(), key = { category ->
                        category.id
                    }) { zekirCategory ->
                        ZekirCategoryCard(
                            zekirCategory = zekirCategory,
                            navController = navController,
                            onFavoriteIconClicked = {
                                favoriteScreenViewModel.updateZekirCategory(
                                    zekirCategory.id,
                                    !zekirCategory.isFavorite
                                )
                            }
                        )
                    }
                    item {
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                    }
                }
            }
        }
    }
}