package com.example.myapplication.navigate

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.SokdakApplication
import com.example.myapplication.screens.BottomNavItem
import com.example.myapplication.screens.CompanyRegistration
import com.example.myapplication.screens.EnterpriseChatScreen
import com.example.myapplication.screens.MainScreen
import com.example.myapplication.screens.MyChatScreen
import com.example.myapplication.screens.MyPageScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable(BottomNavItem.Main.screenRoute) {
            MainScreen(navController = navController)
        }
        composable(BottomNavItem.MyPage.screenRoute){
            MyPageScreen(navController = navController)
        }
        composable(BottomNavItem.MyChat.screenRoute){
            MyChatScreen(navController = navController)
        }
        composable(BottomNavItem.EnterpriseChat.screenRoute){
            EnterpriseChatScreen(navController = navController)
        }
        composable(BottomNavItem.CompanyRegistration.screenRoute){
            CompanyRegistration(navController = navController)
        }
            
    }


}