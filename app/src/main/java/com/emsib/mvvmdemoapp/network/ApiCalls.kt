package com.emsib.mvvmdemoapp.network

import com.emsib.mvvmdemoapp.BuildConfig
import com.emsib.mvvmdemoapp.libs.Constants
import com.emsib.mvvmdemoapp.models.Post
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiCalls {

//    @FormUrlEncoded
//    @POST("v1/appAuth")
//    suspend fun login(@Field("username") email: String, @Field("password") password: String): Response<LoginResponse>

    @GET("posts")
    suspend fun getPosts() : Response<ArrayList<Post>>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
//            authenticationManager: AuthenticationManager
        ): ApiCalls {

            val okHttpClientBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)


            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BASIC
                logging.level = HttpLoggingInterceptor.Level.HEADERS
                logging.level = HttpLoggingInterceptor.Level.BODY
                okHttpClientBuilder.addInterceptor(logging)
            }

            okHttpClientBuilder.addInterceptor { chain ->
                val newUrl = chain.request().url()
                    .newBuilder()
                    .build()

                val newRequest = chain.request().newBuilder()
                newRequest.addHeader("Content-Type", "application/json")
//                authenticationManager.getAccessToken()?.let {
//                    newRequest.addHeader("token", it)
//                    Log.d("APICALL", "token ==>  $it")
//                }
                newRequest.url(newUrl)

                chain.proceed(newRequest.build())
            }

            okHttpClientBuilder.addInterceptor(networkConnectionInterceptor)

            return Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
                .create(ApiCalls::class.java)
        }
    }
}