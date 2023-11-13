package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.MemberJoinRequest
import com.example.myapplication.model.MemberJoinResponse
import com.example.myapplication.model.Resource
import com.example.myapplication.model.State
import com.example.myapplication.repository.SokdakRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class SokdakViewModel @Inject constructor(
    private val SokdakRepository: SokdakRepository
) : ViewModel() {

    private val _memberState = MutableStateFlow<Resource<MemberJoinResponse>>(Resource(State.LOADING, null, null))

    val memberState: StateFlow<Resource<MemberJoinResponse>>get() = _memberState

    fun memberJoin(request: MemberJoinRequest) = viewModelScope.launch {
        _memberState.emit(Resource(State.LOADING, null, null))
        try {
            val response = SokdakRepository.memberJoin(request)
            _memberState.emit(response)
        } catch(e:Exception) {
            _memberState.emit(Resource(State.ERROR, null,e.localizedMessage))
        }

    }

}


