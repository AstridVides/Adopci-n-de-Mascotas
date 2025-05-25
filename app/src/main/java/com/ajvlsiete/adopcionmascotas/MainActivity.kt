package com.ajvlsiete.adopcionmascotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.ajvlsiete.adopcionmascotas.ui.navigation.NavGraph
import com.ajvlsiete.adopcionmascotas.ui.viewModel.PetViewModel
import com.ajvlsiete.adopcionmascotas.ui.theme.AdopcionMascotasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val petViewModel by viewModels<PetViewModel>()
        setContent {
            AdopcionMascotasTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, viewModel = petViewModel)

            }
        }
    }
}


