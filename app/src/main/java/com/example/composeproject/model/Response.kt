package com.example.composeproject.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.composeproject.model.Article

class Response {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("totalResults")
    var totalResults: Int? = null

    @SerializedName("articles")
    var articles: List<Article> = ArrayList()
}