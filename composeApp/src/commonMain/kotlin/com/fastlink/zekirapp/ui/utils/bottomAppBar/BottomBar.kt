package com.fastlink.zekirapp.ui.utils.bottomAppBar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.fastlink.zekirapp.appData.model.ZekirCategoryModel
import com.fastlink.zekirapp.navigation.Screen
import org.jetbrains.compose.resources.painterResource
import zekirapp.composeapp.generated.resources.Res
import zekirapp.composeapp.generated.resources.ic_copy

sealed interface BottomBarItemIcon {
    data class PainterResourceSource(val painter: Painter) : BottomBarItemIcon
    data class ImageVectorSource(val imageVector: ImageVector) : BottomBarItemIcon
}

data class BottomBarItem(
    val icon: BottomBarItemIcon,
    val label: String?,
    val selected: Boolean,
    val onClicked: () -> Unit
)

@Composable
fun BottomBar(bottomBarItems: List<BottomBarItem>) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)),
        contentPadding = PaddingValues(horizontal = 90.dp)
    ) {
        for (i in bottomBarItems.indices) {
            BottomAppBarItem(
                icon = bottomBarItems[i].icon,
                text = bottomBarItems[i].label,
                selected = bottomBarItems[i].selected,
                onClicked = bottomBarItems[i].onClicked
            )
            if (i < bottomBarItems.size - 1) {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun getListOfBottomBarItemsInZekirScreen(
    zekirCategory: ZekirCategoryModel,
    onCopyIconClicked: () -> Unit,
    onFavoriteIconClicked: () -> Unit
): List<BottomBarItem> {
    val bottomBarItems = listOf(
        BottomBarItem(
            icon = BottomBarItemIcon.PainterResourceSource(painterResource(resource = Res.drawable.ic_copy)),
            label = null,
            selected = true,
            onClicked = onCopyIconClicked
        ),
        BottomBarItem(
            icon = BottomBarItemIcon.ImageVectorSource(if (zekirCategory.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder),
            label = null,
            selected = true,
            onClicked = onFavoriteIconClicked
        ),
    )
    return bottomBarItems
}


fun getListOfBottomBarItems(
    homeIconLabel: String,
    favoriteIconLabel: String,
    navController: NavController,
    navBackStackEntry: NavBackStackEntry,
): List<BottomBarItem> {

    val bottomBarItems = listOf(
        BottomBarItem(
            icon = BottomBarItemIcon.ImageVectorSource(Icons.Default.Home),
            label = homeIconLabel,
            selected = navBackStackEntry.destination.route == Screen.Home.route,
            onClicked = {
                if (navBackStackEntry.destination.route != Screen.Home.route) {
                    navController.navigate(Screen.Home.route)
                }
            }),
        BottomBarItem(
            icon = BottomBarItemIcon.ImageVectorSource(Icons.Default.Favorite),
            label = favoriteIconLabel,
            selected = navBackStackEntry.destination.route == Screen.Favorite.route,
            onClicked = {
                if (navBackStackEntry.destination.route != Screen.Favorite.route) {
                    navController.navigate(Screen.Favorite.route)
                }
            }),
    )
    return bottomBarItems
}