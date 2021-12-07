package com.example.appmobile

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInService {
    @POST("/auth/signin")
    fun login(@Body credentials: SignInReq ): Call<SignInRes>
}