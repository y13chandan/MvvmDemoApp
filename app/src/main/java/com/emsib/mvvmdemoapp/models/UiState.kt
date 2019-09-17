package com.emsib.mvvmdemoapp.models

sealed class UiState
data class Success(val data: Any) : UiState()
data class Failed(val error: String) : UiState()