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

interface nftApi {
    @GET("/rarity/{address}")
    suspend fun GET_nft(
        @Path("address") address: String,
    ) : Response<List<String>>

}
data class crypto_data(
    var award:Float,
    var id:Int,
    var metascore:Float,
    var ocurrences:Int,
    var score:Float,
    var text_sentiment:Float,
    var title_sentiment: Float,
    var token: String,
    var upvote_ratio: Float
)

interface cryptoApi {
    @GET("/crypto_data")
    suspend fun GET_crypto() : Response<List<crypto_data>>

}

object RetrofitHelper {
    val baseUrl = "http://146.190.1.241/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}