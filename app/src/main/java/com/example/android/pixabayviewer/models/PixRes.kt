package com.example.android.pixabayviewer.models


//import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


/**
 * Created by wahyu on 10 Desember 2016.
 */
class PixRes {
    /**
     * @return The totalHits
     */
    /**
     * @param totalHits The totalHits
     */

    //@SerializedName("totalHits")
    //@Expose
    @Json(name = "totalHits")
    var totalHits = 0
    /**
     * @return The hits
     */
    /**
     * @param hits The hits
     *//*
    @SerializedName("hits")
    @Expose*/
    @Json(name = "hits")
    var hits: List<Hit>? = null
    /**
     * @return The total
     */
    /**
     * @param total The total
     *//*
    @SerializedName("total")
    @Expose*/
    @Json(name = "total")
    var total = 0
}