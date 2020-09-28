package id.my.okisulton.myapplication.api

import id.my.okisulton.myapplication.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int
    ):Response<List<Post>>

    @GET("posts")
    suspend fun getCustomMapPost(
        @Query("UserId") UserId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ):Response<List<Post>>

    @GET("posts")
    suspend fun getCustomMapPost2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ):Response<List<Post>>
}