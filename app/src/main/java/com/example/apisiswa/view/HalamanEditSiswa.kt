package com.example.apisiswa.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apisiswa.uicontroller.DestinasiEdit
import com.example.apisiswa.viewmodel.EditVM
import com.example.apisiswa.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanEditSiswa (
    navigateBack:()->Unit,
    onNavigateUp:()->Unit,
    modifier: Modifier= Modifier,
    viewModel: EditVM= viewModel(factory = PenyediaViewModel.Factory)
){
    Scaffold (
        
    ){

    }
}