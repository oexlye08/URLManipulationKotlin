package id.my.okisulton.myapplication.repository

import id.my.okisulton.myapplication.api.RetrofitInstance
import id.my.okisulton.myapplication.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post>{
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(userId: Int): Response<List<Post>>{
        return  RetrofitInstance.api.getCustomPost(userId)
    }

    suspend fun getCustomMapPost(UserId: Int, sort: String, order: String): Response<List<Post>>{
        return  RetrofitInstance.api.getCustomMapPost(UserId, sort, order)
    }

    suspend fun getCustomMapPost2(userId: Int, options: Map<String, String>): Response<List<Post>>{
        return  RetrofitInstance.api.getCustomMapPost2(userId, options)
    }
}