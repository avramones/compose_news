package com.example.composeproject.data.api

import com.example.composeproject.utils.Constants
import kotlinx.coroutines.flow.flow

class ApiClient {

    private val service = RetrofitClient.instance().create(ApiService::class.java)

    fun loadNews() = flow {
        emit(service.loadNews(Constants.COUNTRY, Constants.API_KEY))
    }

}