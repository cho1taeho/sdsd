package com.example.myapplication.screens

import com.example.myapplication.R

sealed class BottomNavItem(
    val title: String,  val screenRoute: String
) {
    companion object{
        fun fromRoute(route: String): BottomNavItem{
            return when (route) {
                "main" -> Main
                "companyRegistration" -> CompanyRegistration
                "myChat" -> MyChat
                "myPage" -> MyPage
                "enterpriseChat" -> EnterpriseChat

                else -> Main
            }
        }
    }
    object Main : BottomNavItem("메인", "main")
    object CompanyRegistration : BottomNavItem("회사등록", "companyRegistration")
    object MyChat : BottomNavItem("내채팅","myChat")
    object MyPage : BottomNavItem("마이페이지", "myPage")
    object EnterpriseChat : BottomNavItem("회사채팅", "enterpriseChat")



}