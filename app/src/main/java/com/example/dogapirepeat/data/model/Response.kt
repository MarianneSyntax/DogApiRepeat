package com.example.dogapirepeat.data.model

import com.squareup.moshi.Json

data class Response(
    @Json(name = "message")
    val dogList: List<String>
)
