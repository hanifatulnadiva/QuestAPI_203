package com.example.apisiswa.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.apisiswa.modeldata.DataSiswa
import com.example.apisiswa.repositori.RepositoryDataSiswa
import com.example.apisiswa.uicontroller.DestinasiDetail


sealed interface StatusUIDetail{
    data class Success(val satusiswa: DataSiswa): StatusUIDetail
    object Error: StatusUIDetail
    object Loading : StatusUIDetail
}
class DetailVM (savedStateHandle: SavedStateHandle, private  val repositoryDataSiswa: RepositoryDataSiswa): ViewModel(){
    private  val idSiswa:Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private  set


}