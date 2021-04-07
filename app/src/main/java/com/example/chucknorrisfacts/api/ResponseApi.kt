package com.example.chucknorrisfacts.api

sealed class ResponseApi {

    class Success(val data: Any?) : ResponseApi()
    class Error(val msg: String) : ResponseApi()

}
