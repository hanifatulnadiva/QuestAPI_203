package com.example.apisiswa.viewmodel

import com.example.apisiswa.modeldata.DataSiswa


sealed interface StatusUIDetail{
    data class Success(val satusiswa: DataSiswa): StatusUIDetail
    object Error: StatusUIDetail
    object Loading : StatusUIDetail
}
