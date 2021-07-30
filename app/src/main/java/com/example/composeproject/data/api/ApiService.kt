package com.example.composeproject.data.api

import com.example.composeproject.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun loadNews(@Query ("country") country : String, @Query ("apiKey") apiKey : String) : Response

}