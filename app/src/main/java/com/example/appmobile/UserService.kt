package com.example.appmobile

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {
    @GET("/users/me")
    fun getMyData(@Header("Authorization") authorization: String): Call<BaseGetResponse<UserRes>>
}