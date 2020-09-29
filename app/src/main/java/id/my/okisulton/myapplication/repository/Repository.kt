package id.my.okisulton.myapplication.repository

import id.my.okisulton.myapplication.api.RetrofitInstance
import id.my.okisulton.myapplication.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post>{
        return RetrofitInstance.api.getPost()
    }
    suspend fun getPostHeader(): Response<Post>{
        return RetrofitInstance.api.getPostHeader()
    }
    suspend fun getPostHeader2(auth: String): Response<Post> {
        return RetrofitInstance.api.getPostHeader2(auth)
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
    suspend fun pushPost(post: Post): Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPost2(userId: Int, id: Int, title: String, body: String): Response<Post>{
        return RetrofitInstance.api.pushPost2(userId, id, title, body)
    }
}