package com.example.horrorfan.webservice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.horrorfan.database.HorrorDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel (val database: HorrorDao, application: Application) : AndroidViewModel(application){

    init{
        getPostsProperties()
    }

    private val _response = MutableLiveData<List<Post>>()
    val response: LiveData<List<Post>>
        get() = _response


    private fun getPostsProperties() {
        CoroutineScope(Job() + Dispatchers.Main).launch {
            var getPropertiesDeferred =
                PostsApi.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeferred.await()
                _response.value = listResult
            } catch (e: Exception) {
                _response.value = emptyList()
            }
        }
    }


}