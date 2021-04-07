package com.example.chucknorrisfacts.repository

import com.example.chucknorrisfacts.api.ApiService
import com.example.chucknorrisfacts.api.ResponseApi
import java.lang.Exception

class MainRepository {

    suspend fun getFacts(query: String): ResponseApi {
        return try{
            val response = ApiService.api.searchFacts(query)

            if(response.isSuccessful){
                ResponseApi.Success(response.body())
            }
            else{
                ResponseApi.Error("Erro")
            }
        }catch (exception: Exception){
            ResponseApi.Error("ERRO CARREGAR")
        }
    }
}