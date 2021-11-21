package com.infy.telstra.repo

import androidx.lifecycle.LiveData
import com.infy.telstra.AppController
import com.infy.telstra.db.getDatabase
import com.infy.telstra.model.FactItem
import com.infy.telstra.model.FactResponse
import com.infy.telstra.network.APIInterface
import com.infy.telstra.network.ApiClient
import io.reactivex.Observable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FactRepository {

    private var list : LiveData<List<FactItem>> = getDatabase(AppController.applicationContext()).factDao().getAllDataSet()
    fun getFactsInfo() : Observable<FactResponse>{
        return ApiClient.getClient()!!.create(APIInterface::class.java).getFacts()
    }

    //Insert fact data in table
    fun insertData(models: List<FactItem>){
        GlobalScope.launch {
            getDatabase(AppController.applicationContext()).factDao().deleteAndInsert(models)
        }
    }

    //Insert fact data in table
    fun insertDataSingle(model:FactItem){
        GlobalScope.launch {
            getDatabase(AppController.applicationContext()).factDao().insertItems(model)
        }
    }

    //Fetch all the data from table
    fun getData() : LiveData<List<FactItem>> {
        return list
    }

}