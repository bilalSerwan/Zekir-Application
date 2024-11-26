package com.fastlink.zekir_app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.compose.rememberNavController
import com.fastlink.zekir_app.di.viewModelModule
import com.fastlink.zekir_app.navigation.Navigation
import com.fastlink.zekir_app.ui.theme.lightScheme
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import zekirapp.composeapp.generated.resources.Bahij_Nassim_Regular
import zekirapp.composeapp.generated.resources.Res


@Composable
@Preview
fun App() {
    MaterialTheme(
        colorScheme = lightScheme,
        typography = Typography(
            titleMedium = TextStyle(
                fontFamily = FontFamily(Font(resource = Res.font.Bahij_Nassim_Regular))
            ),
            titleLarge = TextStyle(
                fontFamily = FontFamily(Font(resource = Res.font.Bahij_Nassim_Regular))
            ),
            bodyMedium = TextStyle(
                fontFamily = FontFamily(Font(resource = Res.font.Bahij_Nassim_Regular))
            )
        ),
    ) {
        val navController = rememberNavController()
        KoinApplication(
            application = {
                modules(
                    viewModelModule
                )
            }
        ) {
            Navigation(navController = navController)
        }
    }
}