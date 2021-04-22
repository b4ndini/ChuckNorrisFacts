package com.example.chucknorrisfacts.api

import com.example.chucknorrisfacts.model.Search
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("search")
    fun searchFacts(
        @Query("query")
        query: String
    ): Observable<Search>
}