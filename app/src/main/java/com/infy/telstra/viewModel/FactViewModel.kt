package com.infy.telstra.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infy.telstra.AppController
import com.infy.telstra.db.getDatabase
import com.infy.telstra.model.FactItem
import com.infy.telstra.model.FactResponse
import com.infy.telstra.repo.FactRepository
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FactViewModel : ViewModel() {
    var factList = MutableLiveData<FactResponse>()
    var title : String = ""
    var factRepository = FactRepository()
    var getAllFacts= factRepository.getData()

    fun loadData(){

        factRepository.getFactsInfo()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(getFactsFromAPI())
    }


    private fun getFactsFromAPI(): Observer<FactResponse>{
        return object : Observer<FactResponse>{
            override fun onNext(factResponse: FactResponse){
                factRepository.deleteData()
                   factList.value = factResponse
                title = factResponse.title
                  factList.value!!.rows.forEach { e -> factRepository.insertData(e) }
            }

            override fun onSubscribe(d: Disposable) {
                Log.i("onSubscribe", "onSubscribe")
            }

            override fun onError(e: Throwable) {
                Log.i("onError", e.toString())

            }

            override fun onComplete() {

                getAllFacts = factRepository.getData()
            }
        }

    }

     fun getAllFacts()
    {
        getAllFacts = factRepository.getData()
    }

}