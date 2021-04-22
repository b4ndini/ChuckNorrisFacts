package com.example.chucknorrisfacts.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val api = getChuckApiClient().create(ChuckNorrisApi::class.java)

    private fun getChuckApiClient(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.chucknorris.io/jokes/")
            .build()
    }

}
