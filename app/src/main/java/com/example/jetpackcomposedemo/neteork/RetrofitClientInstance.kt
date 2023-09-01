package com.example.jetpackcomposedemo.neteork

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClientInstance {

    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(context: Context): Retrofit {
        return retrofit ?: synchronized(this) {
            retrofit ?: buildRetrofitApi().also { retrofit = it }
        }
    }

    val apiService: APIService = buildRetrofitApi().create(APIService::class.java)


    private fun buildRetrofitApi(
    ): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level =
            HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl("http://demo7625004.mockable.io/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
