package com.ajvlsiete.adopcionmascotas.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ajvlsiete.adopcionmascotas.models.Pet
import com.ajvlsiete.adopcionmascotas.models.PetRepository

@Composable
fun PetDetail(
    pet: Pet
) {
    Log.d("PetDetail", "Mostrando detalles para: ${pet.name}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = pet.imageUrl,
            contentDescription = pet.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Nombre: ${pet.name}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            "Tipo: ${pet.type}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "Edad: ${pet.age}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PetDetailPreview() {
    val pet = PetRepository.pets.first()
    PetDetail(pet = pet)
}