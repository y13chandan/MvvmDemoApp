package com.emsib.mvvmdemoapp.screen.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emsib.mvvmdemoapp.models.DataWrapper
import com.emsib.mvvmdemoapp.models.Post
import com.emsib.mvvmdemoapp.repository.HomeRepository
import com.emsib.mvvmdemoapp.util.Coroutines

class HomeViewModel(
    private val repository: HomeRepository
): ViewModel() {
    val showProgress = MutableLiveData<Boolean>()
    val posts = MutableLiveData<DataWrapper>()

    fun getPosts() {
        showProgress.value = true
        Coroutines.main {
            try {
                posts.value = DataWrapper(repository.getPosts(), null)
                showProgress.value = false
            } catch (e: Exception) {
                posts.value = DataWrapper(null, e.message)
                showProgress.value = false
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