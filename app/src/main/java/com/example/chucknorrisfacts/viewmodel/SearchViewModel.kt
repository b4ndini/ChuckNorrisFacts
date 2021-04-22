package com.example.chucknorrisfacts.viewmodel

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.example.chucknorrisfacts.model.Search
import com.example.chucknorrisfacts.model.business.SearchBusiness
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel : ViewModel(){

    var business: SearchBusiness = SearchBusiness()
    val factLiveData: MutableLiveData<Search> = MutableLiveData()
    val errorMsgLiveData: MutableLiveData<String> = MutableLiveData()
    lateinit var disposable: Disposable

    fun setQuery(query: String){
         business.getFacts(query)
             .subscribeOn(Schedulers.newThread())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(object : Observer<Search> {
            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(data: Search) {
                if (data.result.isEmpty()) {
                    errorMsgLiveData.postValue("Nothing was found =(")
                } else {
                    factLiveData.postValue(data)
                }
            }

            override fun onError(e: Throwable) {
                errorMsgLiveData.postValue("Something went wrong")
            }

            override fun onComplete() {
                //
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }

}