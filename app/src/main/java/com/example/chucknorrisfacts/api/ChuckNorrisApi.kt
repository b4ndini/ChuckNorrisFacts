package com.example.chucknorrisfacts.api

import com.example.chucknorrisfacts.model.Search
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("search")
    suspend fun searchFacts(
        @Query("query")
        query: String
    ): Response<Search>

}