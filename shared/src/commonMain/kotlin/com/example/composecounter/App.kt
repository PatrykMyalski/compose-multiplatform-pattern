package com.example.composecounter

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composecounter.main.AppViewModel
import com.example.composecounter.main.MainView
import com.example.composecounter.theme.AppTheme
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean
) {
    AppTheme(darkTheme, dynamicColor){

        // Creating instance of viewModel
        val viewModel = getViewModel(
            key = "main-screen",
            factory = viewModelFactory {
                AppViewModel()
            }
        )

        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
            MainView(state = viewModel)
        }
    }
}