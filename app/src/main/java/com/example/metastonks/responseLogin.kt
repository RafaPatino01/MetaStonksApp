package com.example.metastonks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
data class Result(
    val _id: String,
    val value: String
)*/

interface loginApi {
    @GET("/login/rafaxdnn/cdd454daa583d821b79fb81fb7b412d1dcd9af5c6bb60928c4d959e629d505c5")
    suspend fun GET_login() : Response<List<String>>
}

object RetrofitHelper {

    val baseUrl = "http://146.190.1.241/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}