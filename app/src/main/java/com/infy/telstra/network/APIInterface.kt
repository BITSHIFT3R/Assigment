package com.infy.telstra.network

import com.infy.telstra.model.FactResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface APIInterface {

    @GET("facts.json")
    fun getFacts(): Observable<FactResponse>
}