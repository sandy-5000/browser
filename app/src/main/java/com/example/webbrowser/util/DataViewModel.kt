package com.example.webbrowser.util

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class BrowserUiState(
    val name: String = "",
    val count: Int = 0,
    val email: String = "",
)

class DataViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(BrowserUiState())
    val uiState: StateFlow<BrowserUiState> = _uiState.asStateFlow()

    init {
        reset()
    }

    private fun reset() {
        _uiState.value = BrowserUiState(
            name = "Sandy Blaze",
            count = 0,
            email = "sandyblaze911@gmail.com"
        )
    }

    fun incrementCount() {
        val currentState = _uiState.value
        val updatedCount = currentState.count + 1
        val updatedUiState = currentState.copy(count = updatedCount)
        _uiState.value = updatedUiState
    }

}
