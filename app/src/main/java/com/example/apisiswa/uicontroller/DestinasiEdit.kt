package com.example.apisiswa.uicontroller

import com.example.apisiswa.R
object DestinasiEdit: DestinasiNavigasi{
    override  val route= "item_edit"

    override val titleRes=R.string.Edit_Siswa

    const val itemIdArg ="idSiswa"

    val routeWithArgs ="$route/{$itemIdArg}"
}