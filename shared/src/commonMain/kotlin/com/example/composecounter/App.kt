package com.example.composecounter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color



@Composable
fun App(){

    // Here  you write code

    var count by remember {
        mutableStateOf(0)
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Button(onClick = {count++}){
            Text("Count: $count")
        }
    }

}