package com.infy.telstra.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        private var retrofit: Retrofit?= null
        fun getClient(): Retrofit?{
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit
        }

    }
}