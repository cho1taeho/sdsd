package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.ApiService
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
    suspend fun memberIdCheck(request: MemberIdCheckRequest): Resource<MemberIdCheckResponse>{
        val response = apiService.memberIdCheck(request)
        return if (response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun memberNicknameCheck(request: MemberNicknameCheckRequest): Resource<MemberNicknameCheckResponse>{
        val response = apiService.memberNicknameCheck(request)
        return if (response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun memberEmailCheck(request: MemberEmailCheckRequest): Resource<MemberEmailCheckResponse>{
        val response = apiService.memberEmailCheck(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(),"SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun authEmailRequire(request: AuthEmailRequest): Resource<AuthEmailResponse>{
        val response = apiService.authMail(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun authEmailCodeConfirm(request: AuthEmailCodeConfirmRequest): Resource<AuthEmailCodeConfirmResponse>{
        val response = apiService.authEmailCodeConfirm(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun authTokenRefresh(request: AuthRefreshRequest): Resource<AuthRefreshResponse>{
        val response = apiService.authRefresh(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun resetPasswordEmail(request: MemberResetPasswordEmailRequest): Resource<MemberResetPasswordEmailResponse>{
        val response = apiService.resetPasswordEmail(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun resetPasswordCode(request: MemberResetPasswordCodeRequest): Resource<MemberResetPasswordCodeResponse>{
        val response = apiService.resetPasswordCode(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun resetPassword(request: MemberResetPasswordRequest): Resource<MemberResetPasswordResponse>{
        val response = apiService.resetPassword(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun login(request: LoginRequest): Resource<LoginResponse>{
        val response = apiService.login(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
    suspend fun logout(request: LogoutRequest): Resource<LogoutResponse>{
        val response = apiService.logout(request)
        return if(response.isSuccessful){
            Resource(State.SUCCESS, response.body(), "SUCCESS!")
        }else{
            Resource(State.ERROR, null, "ERROR")
        }
    }
}