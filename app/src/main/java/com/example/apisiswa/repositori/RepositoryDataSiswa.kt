package com.example.apisiswa.repositori

import com.example.apisiswa.apiservice.ServiceAppSiswa
import com.example.apisiswa.modeldata.DataSiswa
import retrofit2.Response

interface RepositoryDataSiswa {
    suspend fun getDataSiswa():List<DataSiswa>
    suspend fun  postDataSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val serviceAppSiswa: ServiceAppSiswa
): RepositoryDataSiswa{
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceAppSiswa.getSiswa()
    override suspend fun postDataSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void> = serviceAppSiswa.postSiswa(dataSiswa)

}