package com.infy.telstra.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.infy.telstra.model.FactItem

@Dao
interface FactDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItems(fact: FactItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(facts: List<FactItem>)

    @Transaction
    fun deleteAndInsert(facts:  List<FactItem>) {
        deleteAllItems()
        insertAll(facts)
    }

    @Query("SELECT * FROM FactItem")
    fun getAllDataSet(): LiveData<List<FactItem>>

    @Query("DELETE FROM FactItem")
    fun deleteAllItems()
}