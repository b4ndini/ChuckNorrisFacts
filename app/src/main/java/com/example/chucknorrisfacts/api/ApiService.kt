package com.example.chucknorrisfacts.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val api = getChuckApiClient().create(ChuckNorrisApi::class.java)


    private fun getChuckApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}