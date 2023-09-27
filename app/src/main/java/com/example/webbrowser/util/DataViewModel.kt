package com.example.webbrowser.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class BrowserUiState(
    var name: String = "",
    var count: Int = 0,
    var username: String = "sandyblaze",
    var password: String = "",
    val defaultPassword: String = "sandyblaze",
)

class DataViewModel: ViewModel() {
    private val _uiState = MutableLiveData(BrowserUiState())
    val uiState: LiveData<BrowserUiState> = _uiState

    fun incrementCount() {
        _uiState.value?.count = _uiState.value?.count!! + 1
    }
}
