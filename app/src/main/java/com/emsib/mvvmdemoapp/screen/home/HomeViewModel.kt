package com.emsib.mvvmdemoapp.screen.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emsib.mvvmdemoapp.models.DataWrapper
import com.emsib.mvvmdemoapp.models.Failed
import com.emsib.mvvmdemoapp.models.Success
import com.emsib.mvvmdemoapp.models.UiState
import com.emsib.mvvmdemoapp.repository.HomeRepository
import com.emsib.mvvmdemoapp.util.Coroutines

class HomeViewModel(
    private val repository: HomeRepository
): ViewModel() {
    val progress = MutableLiveData<Boolean>()
    val posts = MutableLiveData<UiState>()

    fun getPosts() {
        progress.value = true
        Coroutines.main {
            try {
                posts.value = Success(repository.getPosts())
                progress.value = false
            } catch (e: Exception) {
                e.message?.let { posts.value = Failed(it) }
                progress.value = false
            }
        }
    }


    // if you want to show some specific thing on internet error or on api error then simply use the catch block like this
//            catch (e: ApiException) {
//
//            } catch (e: NoInternetException) {
//
//            }
}