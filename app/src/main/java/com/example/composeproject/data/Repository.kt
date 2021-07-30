package com.example.composeproject.data

import com.example.composeproject.R
import com.example.composeproject.data.api.ApiClient
import com.example.composeproject.model.History
import kotlinx.coroutines.flow.flow

class Repository {

    private val apiClient = ApiClient()

    fun loadNews() = apiClient.loadNews()

    fun fetchHistories() = flow {
        emit(
            mutableListOf(
                History(R.drawable.img, "Baby pizza"),
                History(R.drawable.img_1, "Noosle"),
                History(R.drawable.img_2, "Aidar"),
                History(R.drawable.img_3, "Ramone"),
                History(R.drawable.img_4, "Ildar")
            )
        )
    }

}