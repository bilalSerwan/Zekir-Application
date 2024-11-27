package com.fastlink.zekirapp.ui.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fastlink.zekirapp.appData.model.ZekirCategoryModel
import com.fastlink.zekirapp.navigation.Screen

@Composable
fun ZekirCategoryCard(
    zekirCategory: ZekirCategoryModel,
    navController: NavController,
    onFavoriteIconClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .heightIn(min = 70.dp, max = 150.dp)
            .padding(
                start = MaterialTheme.spacing.medium,
                top = MaterialTheme.spacing.medium,
                end = MaterialTheme.spacing.medium,
            )
            .clip(RoundedCornerShape(10.dp)),
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("${Screen.ZekirScreen.route}/${zekirCategory.id}")
                }
                .padding(vertical = MaterialTheme.spacing.small),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(imageVector = if (zekirCategory.isFavorite) Icons.Default.Favorite
            else Icons.Default.FavoriteBorder,
                contentDescription = "Favorite",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(start = MaterialTheme.spacing.medium)
                    .size(25.dp)
                    .clickable {
                        onFavoriteIconClicked()
                    })
            Text(
                text = zekirCategory.zekirCategoryTitle,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.spacing.small)
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}