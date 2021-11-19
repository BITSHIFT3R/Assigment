package com.infy.telstra.db;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infy.telstra.model.FactItem


@Dao
interface FactDAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItems(fact: FactItem)

    @Query("SELECT * FROM FactItem")
    fun getAllDataSet(): LiveData<List<FactItem>>

    @Query("DELETE FROM FactItem")
    fun deleteAllItems()

}