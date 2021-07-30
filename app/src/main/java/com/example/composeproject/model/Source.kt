package com.example.composeproject.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Source {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null
}