package com.example.apisiswa.modeldata

import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
data class DataSiswa (
    val id: Int,
    val nama: String,
    val alamat: String,
    val telpon: String
)
