package com.example.a095ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    Dospem1: List<String>,
    Dospem2: List<String>,
    onSelectionChanged: (String) -> Unit,
    onConfirmButtonClicked: (Int) -> Unit,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var nmMhs by remember {
        mutableStateOf("")
    }
    var nimMhs by remember {
        mutableStateOf("")
    }
    var knsntrs by remember {
        mutableStateOf("")
    }
    var jdlskrps by remember {
        mutableStateOf("")
    }

    var ListDataTxt: MutableList<String> = mutableListOf(nmMhs, nimMhs, knsntrs, jdlskrps)
    var Dospem1 by rememberSaveable { mutableStateOf("") }
    var Dospem2 by rememberSaveable { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Data Pelanggan",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = nmMhs,
            onValueChange = { nmMhs = it },
            label = { Text(stringResource(id = R.string.nmmhs)) },
            placeholder = { Text(text = "Masukkan Nama Pelanggan")}
        )

        OutlinedTextField(
            value = nimMhs,
            onValueChange = { nimMhs = it },
            label = { Text(stringResource(id = R.string.studentID)) },
            placeholder = { Text(text = "Masukkan No Telepon")}
        )

        OutlinedTextField(
            value = knsntrs,
            onValueChange = { knsntrs = it },
            label = { Text(stringResource(id = R.string.knsntrs)) },
            placeholder = { Text(text = "Masukkan Alamat")}
        )
        OutlinedTextField(
            value = jdlskrps,
            onValueChange = { jdlskrps = it },
            label = { Text(stringResource(id = R.string.jdl)) },
            placeholder = { Text(text = "Masukkan Alamat")}
        )
        SelectDospem1(
            options = Dospem2.map { id -> context.resource.getString(id) },
            onSelectionChanged = { ViewModel.setDospem1(it) }
        )
        SelectDospem2(
            options = Dospem2.map { id -> context.resources.getString(id) },
            onSelectionChanged = { ViewModel.setDospem2(it) }
        )

    }
}

@Composable
fun SelectDospem1(
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {}
){
    var selectedValue by rememberSaveable { mutableStateOf("")}

    Column(modifier = Modifier.padding(10.dp)) {
        options.forEach { item ->
            Row(
                modifier = Modifier.selectable(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                )
                Text(item)
            }
        }
    }
}

@Composable
fun SelectDospem2(
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {}
){
    var selectedValue by rememberSaveable { mutableStateOf("")}

    Column(modifier = Modifier.padding(10.dp)) {
        options.forEach { item ->
            Row(
                modifier = Modifier.selectable(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                )
                Text(item)
            }
        }
    }
}
