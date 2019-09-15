package com.emsib.mvvmdemoapp.repository

import com.emsib.mvvmdemoapp.models.Post
import com.emsib.mvvmdemoapp.network.ApiCalls
import com.emsib.mvvmdemoapp.network.SafeApiRequest

class HomeRepository(
    private val api: ApiCalls
) : SafeApiRequest() {
    suspend fun getPosts() : List<Post> {
        return apiRequest { api.getPosts() }
    }
}