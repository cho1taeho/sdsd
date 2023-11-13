package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.ApiService
import com.example.myapplication.model.MemberJoinRequest
import com.example.myapplication.model.MemberJoinResponse
import com.example.myapplication.model.Resource
import com.example.myapplication.model.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject


class SokdakRepository @Inject constructor (
    private val apiService: ApiService
) {
    suspend fun memberJoin(request: MemberJoinRequest): Resource<MemberJoinResponse> {
        val response = apiService.memberJoin(request)
        return if (response.isSuccessful) {
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        } else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
}