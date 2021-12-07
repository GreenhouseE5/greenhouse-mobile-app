package com.example.appmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val retro = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val signInService = retro.create(PostService::class.java)
        val loginRequest = signInService.getPosts()
        loginRequest.enqueue(object: Callback<Array<PostsRes>> {
            override fun onResponse(call: Call<Array<PostsRes>>, response: Response<Array<PostsRes>>) {
                val body = response.body()
                Log.d("REQUEST", body.toString())
            }
            override fun onFailure(call: Call<Array<PostsRes>>, t: Throwable) {
                Log.d("REQUEST", "error")
            }
        })


        val button = findViewById<Button>(R.id.login)
        button.setOnClickListener{
            val userInput: TextView = findViewById(R.id.user)
            val passwordInput: TextView = findViewById(R.id.password)
            if (userInput.text.equals("") || passwordInput.text.equals("")) {
                val errorTextView: TextView = findViewById(R.id.errorTextView)
                "Username & password is required".also { errorTextView.text = it }
            }
            this.login(userInput.text.toString(), passwordInput.text.toString())
        }
    }

    private fun login (email: String, password: String) {
        val errorTextView: TextView = findViewById(R.id.errorTextView)
        val intent = Intent(this, Details::class.java)
        val retro = Retrofit.Builder()
            .baseUrl(getString(R.string.api_url))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val signInService = retro.create(SignInService::class.java)
        val loginRequest = signInService.login(SignInReq(email, password))
        loginRequest.enqueue(object: Callback<SignInRes> {
            override fun onResponse(call: Call<SignInRes>, response: Response<SignInRes>) {
                val body = response.body()
                Log.d("REQUEST", body.toString())
                intent.putExtra("token", body!!.token)
                startActivity(intent)
            }
            override fun onFailure(call: Call<SignInRes>, t: Throwable) {
                "Login error".also { errorTextView.text = it }
            }
        })
    }
}