package com.example.myapplication.model

data class MemberJoinRequest(
    val userId: String,
    val password: String,
    val nickname : String,
    val email : String
)

data class MemberJoinResponse(
    val message : String
)

data class MemberIdCheckRequest(
    val userId : String
)

data class MemberIdCheckResponse(
    val message: String
)

data class MemberNicknameCheckRequest(
    val nickname: String
)

data class MemberNicknameCheckResponse(
    val message: String
)

data class MemberEmailCheckRequest(
    val email: String
)

data class MemberEmailCheckResponse(
    val message: String
)

data class AuthEmailRequest(
    val email: String
)

data class AuthEmailResponse(
    val message: String
)

data class AuthEmailCodeConfirmRequest(
    val email: String,
    val token: String
)

data class AuthEmailCodeConfirmResponse(
    val message: String
)

data class AuthRefreshRequest(
    val Authoriztion : String
)

data class AuthResfreshResponse(
    val message: String
)

data class MemberResetPasswordEmailRequest(
    val email: String
)

data class MemberResetPasswordEmailResponse(
    val message: String
)

data class MemberResetPasswordCodeRequest(
    val email: String,
    val token: String
)

data class MemberResetPasswordCodeResponse(
    val message: String
)

data class MemberResetPasswordRequest(
    val email: String,
    val newPassword: String,
    val passwordConfirm: String
)

data class MemberResetPasswordResponse(
    val message: String
)

data class LoginRequest(
    val userId: String,
    val password: String
)

data class LoginResponse(
    val Authoriztion: String,
    val RefreshToken: String
)

data class LogoutRequest(
    val Authoriztion: String
)

data class LogoutResponse(
    val message: String
)





