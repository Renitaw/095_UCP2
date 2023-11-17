package com.example.a095ucp2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.a095ucp2.ui.theme.DataForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModel  : ViewModel() {
    var namaMhs: String by mutableStateOf("")
        private set
    var nimmhs: String by mutableStateOf("")
        private set
    var konsentrasi: String by mutableStateOf("")
        private set
    var judulskrps: String by mutableStateOf("")
        private set
    var dospem1: String by mutableStateOf("")
        private set
    var dospem2: String by mutableStateOf("")
        private set
    private val _uiState = MutableStateFlow(DataForm())
    val uiState: StateFlow<DataForm> = _uiState.asStateFlow()

    fun insertData( nm: String, stid: String, knsntrs: String, jdl: String, dsn1: String, dsn2: String) {
        namaMhs = nm;
        nimmhs = stid;
        konsentrasi = knsntrs;
        judulskrps = jdl;
        dospem1 = dsn1;
        dospem2 = dsn2;
    }
    fun setDospem1(pilihDospem1: String) {
        _uiState.update { currentState -> currentState.copy(Dospem1 = pilihDospem1) }
    }
    fun setDospem2(pilihDospem2: String) {
        _uiState.update { currentState -> currentState.copy(Dospem2 = pilihDospem1) }
    }

}

