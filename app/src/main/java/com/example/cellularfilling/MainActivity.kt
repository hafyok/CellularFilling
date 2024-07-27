package com.example.cellularfilling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.cellularfilling.Presentation.MainScreen
import com.example.cellularfilling.Presentation.MainViewModel
import com.example.cellularfilling.ui.theme.CellularFillingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel()
        enableEdgeToEdge()
        setContent {
            CellularFillingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(innerPadding, viewModel)
                }
            }
        }
    }
}
