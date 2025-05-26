package com.ajvlsiete.adopcionmascotas.view

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajvlsiete.adopcionmascotas.ui.viewModel.PetViewModel
import com.ajvlsiete.adopcionmascotas.ui.components.PetCard
import com.ajvlsiete.adopcionmascotas.ui.components.SearchBar
import com.ajvlsiete.adopcionmascotas.models.Pet
import com.ajvlsiete.adopcionmascotas.models.PetRepository

@Composable
fun PetList(
    viewModel: PetViewModel,
    onPetClick: (Pet) -> Unit
) {
    val pets by viewModel.filteredPets
    Log.d("PetList", "PetList cargado con ${pets.size} mascotas")
    val searchQuery by viewModel.searchQuery

    Column {
        SearchBar(
            query = searchQuery,
            onQueryChange = viewModel::onSearchChange
        )
        if (pets.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No está en la lista de amigos 😢",
                    color = Color.Gray
                )
            }
        } else {
            LazyColumn {
                items(pets) { pet ->
                    PetCard(pet = pet, onClick = { onPetClick(pet) })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetListPreview() {
    val pets = PetRepository.pets.take(5)

    Column {
        LazyColumn {
            items(pets) { pet ->
                PetCard(pet = pet, onClick = {})
            }
        }
    }
}
