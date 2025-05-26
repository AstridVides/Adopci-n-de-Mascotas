package com.ajvlsiete.adopcionmascotas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ajvlsiete.adopcionmascotas.ui.viewModel.PetViewModel
import com.ajvlsiete.adopcionmascotas.view.PetDetail
import com.ajvlsiete.adopcionmascotas.view.PetList

@Composable
fun NavGraph(navController: NavHostController, viewModel: PetViewModel) {
    NavHost(navController, startDestination = "petList") {
        composable("petList") {
            PetList(viewModel = viewModel) { pet ->
                navController.navigate("petDetail/${pet.id}")
            }
        }
        composable("petDetail/{petId}") { backStackEntry ->
            val petId = backStackEntry.arguments?.getString("petId")?.toIntOrNull()
            val pet = viewModel.filteredPets.value.find { it.id == petId }

            pet?.let {
                PetDetail(
                    pet = it,
                    onBackClick = { navController.popBackStack() }
                )
            }

        }
    }
}