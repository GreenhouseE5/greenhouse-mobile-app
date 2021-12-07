package com.example.appmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)
        val token: String = intent.getStringExtra("token").toString()

        val retro = Retrofit.Builder()
            .baseUrl(getString(R.string.api_url))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val signInService = retro.create(UserService::class.java)
        val loginRequest = signInService.getMyData("Bearer $token")
        loginRequest.enqueue(object: Callback<BaseGetResponse<UserRes>> {
            override fun onResponse(call: Call<BaseGetResponse<UserRes>>, response: Response<BaseGetResponse<UserRes>>) {
                val body = response.body()
                Log.d("REQUEST", body.toString())

            }
            override fun onFailure(call: Call<BaseGetResponse<UserRes>>, t: Throwable) {

            }
        })
    }
}