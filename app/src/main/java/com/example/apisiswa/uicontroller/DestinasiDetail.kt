package com.example.apisiswa.uicontroller

import com.example.apisiswa.R

object DestinasiDetail: DestinasiNavigasi {
    override val route ="item_entry"
    override val titleRes= R.string.Detail_Siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}