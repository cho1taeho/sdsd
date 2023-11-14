package com.example.myapplication.api


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
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface ApiService {
    @POST("/api/member")
    suspend fun memberJoin(@Body request: MemberJoinRequest): Response<MemberJoinResponse>
    @POST("/api/member/user-id/availability")
    suspend fun memberIdCheck(@Body request: MemberIdCheckRequest): Response<MemberIdCheckResponse>
    @POST("/api/member/nickname/availability")
    suspend fun memberNicknameCheck(@Body request: MemberNicknameCheckRequest): Response<MemberNicknameCheckResponse>
    @POST("/api/member/email/availability")
    suspend fun memberEmailCheck(@Body request: MemberEmailCheckRequest): Response<MemberEmailCheckResponse>
    @POST("/api/email/auth")
    suspend fun authMail(@Body request: AuthEmailRequest): Response<AuthEmailResponse>
    @POST("/api/email/auth/check")
    suspend fun authEmailCodeConfirm(@Body request: AuthEmailCodeConfirmRequest): Response<AuthEmailCodeConfirmResponse>
    @POST("/api/auth/refresh")
    suspend fun authRefresh(@Body request: AuthRefreshRequest): Response<AuthRefreshResponse>
    @POST("/api/member/reset-password/email")
    suspend fun resetPasswordEmail(@Body request: MemberResetPasswordEmailRequest): Response<MemberResetPasswordEmailResponse>
    @POST("/api/member/reset-password/code")
    suspend fun resetPasswordCode(@Body request: MemberResetPasswordCodeRequest): Response<MemberResetPasswordCodeResponse>
    @PATCH("/api/member/reset-password")
    suspend fun resetPassword(@Body request: MemberResetPasswordRequest): Response<MemberResetPasswordResponse>
    @POST("/api/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
    @POST("/api/logout")
    suspend fun logout(@Body request: LogoutRequest): Response<LogoutResponse>
}