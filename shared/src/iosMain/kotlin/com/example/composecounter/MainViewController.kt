package com.example.composecounter

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

// Declaring normal function that swift will understand
fun MainViewController() = ComposeUIViewController {

    //Getting darkTheme info
    val isDarkTheme = UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark

    // dynamic colors are not available on ios so dummy false stays
    App(
        darkTheme = isDarkTheme,
        dynamicColor = false
    )
}