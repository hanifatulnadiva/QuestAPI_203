package com.example.apisiswa.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apisiswa.uicontroller.DestinasiDetail
import com.example.apisiswa.viewmodel.DetailVM
import com.example.apisiswa.viewmodel.PenyediaViewModel
import com.example.apisiswa.viewmodel.StatusUIDetail
import com.example.apisiswa.R
import com.example.apisiswa.modeldata.DataSiswa
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDetailSiswa (
    navigateToEditItem:(Int)->Unit,
    navigateBack:()->Unit,
    modifier: Modifier= Modifier,
    viewModel: DetailVM= viewModel(factory = PenyediaViewModel.Factory)
){
    Scaffold(
        topBar ={
            SiswaTopAppBar(
                title = stringResource(DestinasiDetail.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },
        floatingActionButton = {
            val uiState=viewModel.statusUIDetail
            FloatingActionButton(
                onClick = {
                    when(uiState){is StatusUIDetail.Success->
                    navigateToEditItem(uiState.satusiswa.id)
                    else -> {}
                    }
                },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "update"
                )
            }
        }, modifier = modifier
    ) {
        isiRuang->
        val coroutineScope= rememberCoroutineScope()
        BodyDetailDataSiswa(
            statusUIDetail = viewModel.statusUIDetail,
            onDelete={
                coroutineScope.launch {
                    viewModel.hapusSatuSiswa()
                    navigateBack()
            }},
            modifier=modifier
                .padding(isiRuang)
                .verticalScroll(rememberScrollState())
        )
    }
}
