package com.example.android.pixabayviewer.models


import com.squareup.moshi.Json


class PixRes {
    @Json(name = "totalHits")
    var totalHits = 0

    @Json(name = "hits")
    var hits: List<Hit>? = null

    @Json(name = "total")
    var total = 0
}