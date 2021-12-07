package com.example.appmobile

import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    fun getPosts(): Call<Array<PostsRes>>
}