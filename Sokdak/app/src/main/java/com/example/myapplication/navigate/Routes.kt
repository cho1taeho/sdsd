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
import com.example.myapplication.AirbankApplication
import com.example.myapplication.screens.AddChildScreen
import com.example.myapplication.screens.AuthScreen
import com.example.myapplication.screens.BonusTransferScreen
import com.example.myapplication.screens.BottomNavItem
import com.example.myapplication.screens.ChildConfiscationTransferScreen
import com.example.myapplication.screens.ChildInterestRespaymentScreen
import com.example.myapplication.screens.ChildLoanRepaymentScreen
import com.example.myapplication.screens.ChildLoanScreen
import com.example.myapplication.screens.ChildLoanStartScreen
import com.example.myapplication.screens.ChildMainScreen
import com.example.myapplication.screens.ChildRuleScreen
import com.example.myapplication.screens.ChildSavingsApplication
import com.example.myapplication.screens.ChildSavingsScreen
import com.example.myapplication.screens.ChildSavingsTransferScreen
import com.example.myapplication.screens.ChildSavingsWaitingScreen
import com.example.myapplication.screens.ChildTaxTransferScreen
import com.example.myapplication.screens.ChildTransactionHistoryScreen
import com.example.myapplication.screens.ChildWalletScreen
import com.example.myapplication.screens.FirstScreen
import com.example.myapplication.screens.GroupConfirmScreen
import com.example.myapplication.screens.LoanScreen
import com.example.myapplication.screens.MainScreen
import com.example.myapplication.screens.MyPageScreen
import com.example.myapplication.screens.NotificationScreen
import com.example.myapplication.screens.SavingsApproveScreen
import com.example.myapplication.screens.SavingsBonusScreen
import com.example.myapplication.screens.SavingsScreen
import com.example.myapplication.screens.SavingsWaitingScreen
import com.example.myapplication.screens.SignUpScreen
import com.example.myapplication.screens.WalletScreen
import com.example.myapplication.viewmodel.SavingsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavigation(navController: NavHostController) {


}