package com.example.chucknorrisfacts.repository

import com.example.chucknorrisfacts.api.ApiService
import com.example.chucknorrisfacts.model.Search
import io.reactivex.Observable

class MainRepository {

    fun getFacts(query: String): Observable<Search> {

        return ApiService.api.searchFacts(query)

    }

}


