package com.fastlink.zekirapp.ui.utils.bottomAppBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomAppBarItem(
    icon: BottomBarItemIcon,
    text: String?,
    selected: Boolean,
    onClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(
                onClick = onClicked,
                role = Role.Button,
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (icon) {
            is BottomBarItemIcon.ImageVectorSource -> {
                Icon(
                    imageVector = icon.imageVector,
                    contentDescription = "$text icon",
                    modifier = Modifier.size(24.dp),
                    tint = if (selected) MaterialTheme.colorScheme.onPrimary
                    else MaterialTheme.colorScheme.inversePrimary,
                )
            }

            is BottomBarItemIcon.PainterResourceSource -> {
                Icon(
                    painter = icon.painter,
                    contentDescription = "$text icon",
                    modifier = Modifier.size(24.dp),
                    tint = if (selected) MaterialTheme.colorScheme.onPrimary
                    else MaterialTheme.colorScheme.inversePrimary,
                )
            }
        }
        if (text != null) Text(
            text = text,
            color = if (selected) MaterialTheme.colorScheme.onPrimary
            else MaterialTheme.colorScheme.inversePrimary,
            fontSize = 15.sp
        )
    }
}

