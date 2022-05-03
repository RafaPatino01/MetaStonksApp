package com.example.metastonks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

/*
data class Result(
    val _id: String,
    val value: String
)*/

interface loginApi {
    @GET("/login/{user}/{pass}")
    suspend fun GET_login(
        @Path("user") user: String,
        @Path("pass") pass: String
    ) : Response<List<String>>

}

interface registerApi {
    @GET("/register/{mail}/{user}/{pass}")
    suspend fun GET_register(
        @Path("mail") mail: String,
        @Path("user") user: String,
        @Path("pass") pass: String
    ) : Response<List<String>>

}

object RetrofitHelper {
    val baseUrl = "http://146.190.1.241/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}