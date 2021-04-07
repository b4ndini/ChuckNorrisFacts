package com.example.chucknorrisfacts.model.search

import com.example.chucknorrisfacts.api.ResponseApi
import com.example.chucknorrisfacts.repository.MainRepository

class SearchBusiness {

    private val repository by lazy{
        MainRepository()
    }

    suspend fun getFacts(query: String) : ResponseApi {
        return repository.getFacts(query)
    }

}