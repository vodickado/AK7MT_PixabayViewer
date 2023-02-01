package com.example.android.pixabayviewer.models

//import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/**
 * Created by wahyu on 10 Desember 2016.
 */
class Hit {
    /**
     * @return The previewHeight
     */
    /**
     * @param previewHeight The previewHeight
     */
    @Json(name = "previewHeight")
    var previewHeight = 0
    /**
     * @return The likes
     */
    /**
     * @param likes The likes
     */
    @Json(name = "likes")
    var likes = 0
    /**
     * @return The favorites
     */
    /**
     * @param favorites The favorites
     */
    @Json(name = "favorites")
    var favorites = 0
    /**
     * @return The tags
     */
    /**
     * @param tags The tags
     */
    @Json(name = "tags")
    var tags: String? = null
    /**
     * @return The webformatHeight
     */
    /**
     * @param webformatHeight The webformatHeight
     */
    @Json(name = "webformatHeight")
    var webformatHeight = 0
    /**
     * @return The views
     */
    /**
     * @param views The views
     */
    @Json(name = "views")
    var views = 0
    /**
     * @return The webformatWidth
     */
    /**
     * @param webformatWidth The webformatWidth
     */
    @Json(name = "webformatWidth")
    var webformatWidth = 0
    /**
     * @return The previewWidth
     */
    /**
     * @param previewWidth The previewWidth
     */
    @Json(name = "previewWidth")
    var previewWidth = 0
    /**
     * @return The comments
     */
    /**
     * @param comments The comments
     */
    @Json(name = "comments")
    var comments = 0
    /**
     * @return The downloads
     */
    /**
     * @param downloads The downloads
     */
    @Json(name = "downloads")
    var downloads = 0
    /**
     * @return The pageURL
     */
    /**
     * @param pageURL The pageURL
     */
    @Json(name = "pageURL")
    var pageURL: String? = null
    /**
     * @return The previewURL
     */
    /**
     * @param previewURL The previewURL
     */
    @Json(name = "previewURL")
    var previewURL: String? = null
    /**
     * @return The webformatURL
     */
    /**
     * @param webformatURL The webformatURL
     */
    @Json(name = "webformatURL")
    var webformatURL: String? = null
    /**
     * @return The imageWidth
     */
    /**
     * @param imageWidth The imageWidth
     */
    @Json(name = "imageWidth")
    var imageWidth = 0
    /**
     * @return The userId
     */
    /**
     * @param userId The user_id
     */
    @Json(name = "user_id")
    var userId = 0
    /**
     * @return The user
     */
    /**
     * @param user The user
     */
    @Json(name = "user")
    var user: String? = null
    /**
     * @return The type
     */
    /**
     * @param type The type
     */
    @Json(name = "type")
    var type: String? = null
    /**
     * @return The id
     */
    /**
     * @param id The id
     */
    @Json(name = "id")
    var id = 0
    /**
     * @return The userImageURL
     */
    /**
     * @param userImageURL The userImageURL
     */
    @Json(name = "userImageURL")
    var userImageURL: String? = null
    /**
     * @return The imageHeight
     */
    /**
     * @param imageHeight The imageHeight
     */
    @Json(name = "imageHeight")
    var imageHeight = 0
}