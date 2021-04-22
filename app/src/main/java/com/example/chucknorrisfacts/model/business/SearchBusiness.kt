package com.example.chucknorrisfacts.model.business

import com.example.chucknorrisfacts.model.Search
import com.example.chucknorrisfacts.repository.MainRepository
import io.reactivex.Observable

class SearchBusiness {

    private val repository by lazy{
        MainRepository()
    }

     fun getFacts(query: String) : Observable<Search> {
        return repository.getFacts(query)
    }

}