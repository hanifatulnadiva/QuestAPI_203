package com.example.apisiswa.repositori

import android.app.Application
import com.example.apisiswa.apiservice.ServiceAppSiswa
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

interface ContainerApp {
    val repositoryDataSiswa: RepositoryDataSiswa
}

class DefaultContainerApp: ContainerApp{
    private val baseUrl= "http://10.49.0.73/umyTI/"
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val Klien = OkHttpClient.Builder()
        .addInterceptor (logging)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
                prettyPrint=true
                isLenient= true
            }.asConverterFactory("application/json".toMediaType())
        )
        .client(Klien)
        .build()

    private  val retrofitService: ServiceAppSiswa by lazy {
        retrofit.create(ServiceAppSiswa::class.java)
    }
    override val repositoryDataSiswa: RepositoryDataSiswa  by lazy {
        JaringanRepositoryDataSiswa(retrofitService)
    }

}
