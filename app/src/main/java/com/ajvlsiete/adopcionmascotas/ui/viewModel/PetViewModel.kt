package com.ajvlsiete.adopcionmascotas.ui.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.ajvlsiete.adopcionmascotas.models.Pet
import com.ajvlsiete.adopcionmascotas.models.PetRepository

class PetViewModel : ViewModel() {
    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _allPets = PetRepository.pets

    val filteredPets: State<List<Pet>> = derivedStateOf {
        if (_searchQuery.value.isBlank()) _allPets
        else _allPets.filter {
            it.name.contains(_searchQuery.value, ignoreCase = true) ||
                    it.type.contains(_searchQuery.value, ignoreCase = true)
        }
    }

    fun onSearchChange(query: String) {
        _searchQuery.value = query
    }
}
