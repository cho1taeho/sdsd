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
                else -> Main
            }
        }
    }
    object Main : BottomNavItem("메인", "main")
    object CompanyRegistration : BottomNavItem("회사등록", "companyRegistration")

}