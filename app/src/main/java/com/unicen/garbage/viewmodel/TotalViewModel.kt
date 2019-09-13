package com.unicen.garbage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unicen.garbage.data.GarbageServiceGenerator
import com.unicen.garbage.data.KotlinGarbageService
import com.unicen.garbage.domain.entities.Recycling
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TotalViewModel : ViewModel() {
    private val totalRecycling = MutableLiveData<Resource<Recycling>>()

    fun getTotalRecycling(): LiveData<Resource<Recycling>> {
        return totalRecycling
    }

    fun refreshButtonClicked() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val recycling = GarbageServiceGenerator.createService(KotlinGarbageService::class.java).getTotalRecycling()
                    totalRecycling.postValue(Resource.Success(recycling))
                } catch (e: Exception) {
                    totalRecycling.postValue(Resource.Error(e.message ?: ""))
                }
            }
        }
    }
}

// A generic class that contains data and status about loading this data.
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}