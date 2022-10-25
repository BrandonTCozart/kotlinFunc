package com.example.koylinfasten.interfaces

import com.example.koylinfasten.classes.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitEndPoint {

    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>


    //This one is not an end point its just another example
    @GET("/end")
    suspend fun getSomethinElse() : Response<QuoteList>

    @POST("/quotes")
    suspend fun postQuote(): Response<QuoteList>


}