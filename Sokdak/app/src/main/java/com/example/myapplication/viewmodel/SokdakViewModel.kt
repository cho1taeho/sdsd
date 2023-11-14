package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.AuthEmailCodeConfirmRequest
import com.example.myapplication.model.AuthEmailCodeConfirmResponse
import com.example.myapplication.model.AuthEmailRequest
import com.example.myapplication.model.AuthEmailResponse
import com.example.myapplication.model.AuthRefreshRequest
import com.example.myapplication.model.AuthRefreshResponse
import com.example.myapplication.model.LoginRequest
import com.example.myapplication.model.LoginResponse
import com.example.myapplication.model.LogoutRequest
import com.example.myapplication.model.LogoutResponse
import com.example.myapplication.model.MemberEmailCheckRequest
import com.example.myapplication.model.MemberEmailCheckResponse
import com.example.myapplication.model.MemberIdCheckRequest
import com.example.myapplication.model.MemberIdCheckResponse
import com.example.myapplication.model.MemberJoinRequest
import com.example.myapplication.model.MemberJoinResponse
import com.example.myapplication.model.MemberNicknameCheckRequest
import com.example.myapplication.model.MemberNicknameCheckResponse
import com.example.myapplication.model.MemberResetPasswordCodeRequest
import com.example.myapplication.model.MemberResetPasswordCodeResponse
import com.example.myapplication.model.MemberResetPasswordEmailRequest
import com.example.myapplication.model.MemberResetPasswordEmailResponse
import com.example.myapplication.model.MemberResetPasswordRequest
import com.example.myapplication.model.MemberResetPasswordResponse
import com.example.myapplication.model.Resource
import com.example.myapplication.model.State
import com.example.myapplication.repository.SokdakRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SokdakViewModel @Inject constructor(
    private val SokdakRepository: SokdakRepository
) : ViewModel() {

    private val _memberJoinState = MutableStateFlow<Resource<MemberJoinResponse>>(Resource(State.LOADING, null, null))
    val memberJoinState: StateFlow<Resource<MemberJoinResponse>>get() = _memberJoinState
    fun memberJoin(request: MemberJoinRequest) = viewModelScope.launch {
        _memberJoinState.emit(Resource(State.LOADING, null, null))
        try {
            val response = SokdakRepository.memberJoin(request)
            _memberJoinState.emit(response)
        } catch(e:Exception) {
            _memberJoinState.emit(Resource(State.ERROR, null,e.localizedMessage))
        }
    }
    private val _memberIdCheckState = MutableStateFlow<Resource<MemberIdCheckResponse>>(Resource(State.LOADING, null, null))
    val memberIdCheckState: StateFlow<Resource<MemberIdCheckResponse>>get() = _memberIdCheckState
    fun memberIdCheck(request: MemberIdCheckRequest) = viewModelScope.launch {
        _memberIdCheckState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.memberIdCheck(request)
            _memberIdCheckState.emit(response)
        } catch (e:Exception){
            _memberIdCheckState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _memberNicknameCheckState = MutableStateFlow<Resource<MemberNicknameCheckResponse>>(Resource(State.LOADING, null, null))
    val memberNicknameCheckState: StateFlow<Resource<MemberNicknameCheckResponse>>get() = _memberNicknameCheckState
    fun memberNicknameCheck(request: MemberNicknameCheckRequest) = viewModelScope.launch {
        _memberNicknameCheckState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.memberNicknameCheck(request)
            _memberNicknameCheckState.emit(response)
        } catch (e:Exception){
            _memberNicknameCheckState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _memberEmailCheckState = MutableStateFlow<Resource<MemberEmailCheckResponse>>(
        Resource(State.LOADING, null, null)
    )
    val memberEmailCheckState: StateFlow<Resource<MemberEmailCheckResponse>>get() = _memberEmailCheckState
    fun memberEmailCheck(request: MemberEmailCheckRequest) = viewModelScope.launch {
        _memberEmailCheckState.emit(Resource(State.LOADING, null, null))
        try {
            val response = SokdakRepository.memberEmailCheck(request)
        }catch (e:Exception){
            _memberEmailCheckState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _authEmailRequireState = MutableStateFlow<Resource<AuthEmailResponse>>(Resource(State.LOADING, null, null))
    val authEmailRequireState: StateFlow<Resource<AuthEmailResponse>>get() = _authEmailRequireState
    fun authEmailRequire(request: AuthEmailRequest) = viewModelScope.launch {
        _authEmailRequireState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.authEmailRequire(request)
        }catch (e:Exception){
            _authEmailRequireState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _authEmailCodeConfirmState = MutableStateFlow<Resource<AuthEmailCodeConfirmResponse>>(Resource(State.LOADING, null, null))
    val authEmailCodeConfirmState: StateFlow<Resource<AuthEmailCodeConfirmResponse>>get() = _authEmailCodeConfirmState
    fun authEmailCodeConfirm(request: AuthEmailCodeConfirmRequest) = viewModelScope.launch {
        _authEmailCodeConfirmState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.authEmailCodeConfirm(request)
        }catch (e:Exception){
            _authEmailCodeConfirmState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _authRefreshState = MutableStateFlow<Resource<AuthRefreshResponse>>(Resource(State.LOADING, null, null))
    val authRefreshState: StateFlow<Resource<AuthRefreshResponse>>get() = _authRefreshState
    fun authRefresh(request: AuthRefreshRequest) = viewModelScope.launch {
        _authRefreshState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.authTokenRefresh(request)
        }catch (e:Exception){
            _authRefreshState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _memberResetPasswordEmailState = MutableStateFlow<Resource<MemberResetPasswordEmailResponse>>(Resource(State.LOADING, null, null))
    val memberResetPasswordEmailState: StateFlow<Resource<MemberResetPasswordEmailResponse>>get() = _memberResetPasswordEmailState
    fun memberResetPasswordEmail(request: MemberResetPasswordEmailRequest) = viewModelScope.launch {
        _memberResetPasswordEmailState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.resetPasswordEmail(request)
        }catch (e:Exception){
            _memberResetPasswordEmailState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _memberResetPasswordCodeState = MutableStateFlow<Resource<MemberResetPasswordCodeResponse>>(Resource(State.LOADING, null, null))
    val memberResetPasswordCodeState: StateFlow<Resource<MemberResetPasswordCodeResponse>>get() = _memberResetPasswordCodeState
    fun memberResetPasswordCode(request: MemberResetPasswordCodeRequest) = viewModelScope.launch {
        _memberResetPasswordCodeState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.resetPasswordCode(request)
        }catch (e:Exception){
            _memberResetPasswordCodeState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _memberResetPasswordState = MutableStateFlow<Resource<MemberResetPasswordResponse>>(
        Resource(State.LOADING, null, null)
    )
    val memberResetPasswordState: StateFlow<Resource<MemberResetPasswordResponse>>get() = _memberResetPasswordState
    fun memberResetPassword(request: MemberResetPasswordRequest) = viewModelScope.launch {
        _memberResetPasswordState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.resetPassword(request)
        }catch (e:Exception){
            _memberResetPasswordState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _loginState = MutableStateFlow<Resource<LoginResponse>>(Resource(State.LOADING, null, null))
    val loginState: StateFlow<Resource<LoginResponse>>get() = _loginState
    fun login(request: LoginRequest) = viewModelScope.launch {
        _loginState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.login(request)
        }catch (e:Exception){
            _loginState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
    private val _logoutState = MutableStateFlow<Resource<LogoutResponse>>(Resource(State.LOADING, null, null))
    val logoutState: StateFlow<Resource<LogoutResponse>>get() = _logoutState
    fun logout(request: LogoutRequest) = viewModelScope.launch {
        _logoutState.emit(Resource(State.LOADING, null, null))
        try{
            val response = SokdakRepository.logout(request)
        }catch (e:Exception){
            _logoutState.emit(Resource(State.ERROR, null, e.localizedMessage))
        }
    }
}


