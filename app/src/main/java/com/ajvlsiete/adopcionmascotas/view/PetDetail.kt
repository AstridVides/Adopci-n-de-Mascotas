package com.ajvlsiete.adopcionmascotas.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ajvlsiete.adopcionmascotas.models.Pet
import com.ajvlsiete.adopcionmascotas.models.PetRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetDetail(
    pet: Pet,
    onBackClick: () -> Unit
) {
    Log.d("PetDetail", "Mostrando detalles para: ${pet.name}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(0.dp)
                )
        ) {
            TopAppBar(
                title = {
                    Text(
                        "¿Serás mi amigo?",
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        AsyncImage(
            model = pet.imageUrl,
            contentDescription = pet.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Nombre: ${pet.name}",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            "Tipo: ${pet.type}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "Edad: ${pet.age} años",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "Descripción: ${pet.description}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PetDetailPreview() {
    val pet = PetRepository.pets.first()
    PetDetail(
        pet = pet,
        onBackClick = {}
    )
}