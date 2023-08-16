package com.example.composecounter.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


//Specifying android specific theme
@Composable
actual fun AppTheme(darkTheme: Boolean, dynamicColor: Boolean, content: @Composable () -> Unit){

    // choosing what color theme should be used
    val colorScheme = when {
        // checking if dynamicColors are available if not then checking if device is in dark mode
        // if not then app is stays with light theme
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    // Here we are setting status bar color and changing status bar icons color
    val view = LocalView.current
    if(!view.isInEditMode){
        SideEffect{
            val window = (view.context as Activity).window
            // .toArgb() supports dynamic Theme
            window.statusBarColor = colorScheme.primary.toArgb()
            // Setting status bar icons Color
            WindowCompat.getInsetsController(
                window, view
            ).isAppearanceLightStatusBars = darkTheme
        }
    }
    MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}