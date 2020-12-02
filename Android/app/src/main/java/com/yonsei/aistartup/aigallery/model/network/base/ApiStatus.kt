package com.yonsei.aistartup.aigallery.model.network.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData


typealias ApiLiveData<T> = LiveData<ApiStatus<T>>
typealias MutableApiLiveData<T> = MutableLiveData<ApiStatus<T>>
typealias MediatorApiLiveData<T> = MediatorLiveData<ApiStatus<T>>

sealed class ApiStatus<out T> {
    object Loading : ApiStatus<Nothing>()
    class Success<T>(val code: Int, val data: T) : ApiStatus<T>()
    class Error(val code: Int, val message: String) : ApiStatus<Nothing>()
}