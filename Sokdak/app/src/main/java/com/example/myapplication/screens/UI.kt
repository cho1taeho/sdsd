package com.example.myapplication.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.navigate.AppNavigation


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppMainContent(navController: NavHostController) {
    AppNavigation(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MyUI() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
//    var title by remember {mutableStateOf("")}

    Scaffold(
       bottomBar = {
           NavigationBar{
               val items = listOf(
                   BottomNavItem.Main,
                   BottomNavItem.EnterpriseChat,
                   BottomNavItem.MyChat,
                   BottomNavItem.MyPage
               )
               items.forEach {item ->
                   NavigationBarItem(
                       icon = { Spacer(modifier = Modifier.size(0.dp)) },
                       label = {
                           Text(
                               item.title,
                               color = if (currentRoute == item.screenRoute) {
                                   Color.Black
                               } else {
                                   Color.Gray
                               }
                           )
                       },
                       selected = currentRoute == item.screenRoute,
                       onClick = {
                           navController.navigate(item.screenRoute){
                               navController.graph.startDestinationRoute?.let {
                                   popUpTo(it) {saveState = true}
                               }
                           }
                       },
                       alwaysShowLabel = true
                   )
               }
           }
       }
    ) {
        Row(
            modifier = Modifier
                .padding(it)
                .background(Color(0xFFF8F4E8))
            , horizontalArrangement = Arrangement.Center
            , verticalAlignment = Alignment.CenterVertically
        ) {
            com.example.myapplication.layout.AppMainContent(navController = navController)
        }
    }
}





