package com.example.chucknorrisfacts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisfacts.api.ResponseApi
import com.example.chucknorrisfacts.model.Search
import com.example.chucknorrisfacts.model.search.SearchBusiness
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(){

    var business: SearchBusiness = SearchBusiness()
    val factLiveData: MutableLiveData<Search> = MutableLiveData()
    val errorMsgLiveData: MutableLiveData<String> = MutableLiveData()

    fun setQuery(query: String){
        viewModelScope.launch {
            val response =  business.getFacts(query)
            when(response){
                is ResponseApi.Success -> {
                    factLiveData.postValue(response.data as? Search?)
                }
                is ResponseApi.Error -> {
                    errorMsgLiveData.postValue(response.msg)
                }
            }
        }
    }

}