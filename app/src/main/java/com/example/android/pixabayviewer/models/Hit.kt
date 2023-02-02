package com.example.android.pixabayviewer.models

import com.squareup.moshi.Json

class Hit {

    @Json(name = "previewHeight")
    var previewHeight = 0

    @Json(name = "likes")
    var likes = 0

    @Json(name = "favorites")
    var favorites = 0

    @Json(name = "tags")
    var tags: String? = null

    @Json(name = "webformatHeight")
    var webformatHeight = 0

    @Json(name = "views")
    var views = 0

    @Json(name = "webformatWidth")
    var webformatWidth = 0

    @Json(name = "previewWidth")
    var previewWidth = 0

    @Json(name = "comments")
    var comments = 0

    @Json(name = "downloads")
    var downloads = 0

    @Json(name = "pageURL")
    var pageURL: String? = null

    @Json(name = "previewURL")
    var previewURL: String? = null

    @Json(name = "webformatURL")
    var webformatURL: String? = null

    @Json(name = "imageWidth")
    var imageWidth = 0

    @Json(name = "user_id")
    var userId = 0

    @Json(name = "user")
    var user: String? = null

    @Json(name = "type")
    var type: String? = null

    @Json(name = "id")
    var id = 0

    @Json(name = "userImageURL")
    var userImageURL: String? = null

    @Json(name = "imageHeight")
    var imageHeight = 0
}