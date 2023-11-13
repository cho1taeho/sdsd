package com.example.myapplication.screens

import android.app.AlertDialog
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun CompanyRegistration(navController: NavController){

    var companyValue by remember { mutableStateOf(TextFieldValue()) }
    var companyRegisterNumber by remember {  mutableStateOf(TextFieldValue()) }
    var applicantPosition by remember { mutableStateOf(TextFieldValue())}
    var email by remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F4E8))

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.prev),
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .clickable {

                    }
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                "메인화면",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier
                .padding(12.dp)
                .background(Color.White)
                .fillMaxSize()
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "기업 등록 신청서",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp

                )
                Spacer(modifier = Modifier.size(10.dp))

                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .background(Color.White)

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "* 기업 등록 프로세스에 대한 설명 주저리주저리",
                            color = Color.Gray,
                            fontSize = 8.sp
                        )
                        Text(
                            text = "* 뭐 사업자 번호를 확인하고 어쩌고 확인후 1~2일 내에 등록될 ",
                            color = Color.Gray,
                            fontSize = 8.sp
                        )
                        Text(
                            text = "예정입니다.등록이 완료되면 메일로 회신드리도록 하겠습니다.",
                            color = Color.Gray,
                            fontSize = 8.sp
                        )

                    }
                }
                Spacer(modifier = Modifier.size(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "기업명",
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.size(8.dp))
                OutlinedTextField(
                    value = companyValue,
                    onValueChange = {newValue ->
                        companyValue = newValue
                    },

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .width(250.dp)
                        .height(55.dp)
                        .clip(RoundedCornerShape(4.dp)),

                )

                Spacer(modifier = Modifier.size(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "사업자 번호",
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.size(4.dp))
                OutlinedTextField(
                    value = companyRegisterNumber,
                    onValueChange = {newValue ->
                        companyRegisterNumber = newValue
                    },

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .width(250.dp)
                        .height(55.dp)
                        .clip(RoundedCornerShape(4.dp)),

                    )

                Spacer(modifier = Modifier.size(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),

                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "기업메일 주소",
                            fontSize = 14.sp
                        )
                        Text(
                            text = "* 기업 등록 후 등록결과를 회신받을 메일입니다.",
                            color = Color.Gray,
                            fontSize = 8.sp
                        )
                        Text(
                            text = "* 개인 메일이 아닌 기업메일을 입력해주세요. ",
                            color = Color.Gray,
                            fontSize = 8.sp
                        )


                    }
                }
                Spacer(modifier = Modifier.size(4.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = {newValue ->
                        email = newValue
                    },

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .width(250.dp)
                        .height(55.dp)
                        .clip(RoundedCornerShape(4.dp)),

                    )

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(200.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xFFF8F4E8))
                        .clickable {
                            when {
                                companyValue.text.isEmpty() -> Toast
                                    .makeText(context, "기업명을 입력하세요.", Toast.LENGTH_SHORT)
                                    .show()

                                companyRegisterNumber.text.isEmpty() -> Toast
                                    .makeText(context, "사업자 번호를 입력하세요.", Toast.LENGTH_SHORT)
                                    .show()


                                email.text.isEmpty() -> Toast
                                    .makeText(context, "기업메일을 입력하세요.", Toast.LENGTH_SHORT)
                                    .show()

//                                else -> {
//                                    val CompanyRegisterRequest = CompanyRegisterRequest(
//                                        companyNameKr = companyValue.text,
//                                        companyRegistrationNumber = companyRegisterNumber.text,
//                                        companyNameEn = null,
//                                        companyEmailDomain = email.text,
//
//
//                                    )
//
//
////                                    viewModel.CompanyRegister(CompanyRegisterRequest)
//
//
//                                    AlertDialog
//                                        .Builder(context)
//                                        .setTitle("회사 등록")
//                                        .setMessage("회사 등록이 신청되었습니다.")
//                                        .setPositiveButton(android.R.string.ok) { dialog, _ ->
//                                            dialog.dismiss()
//                                            navController.navigate()
//                                        }
//                                        .show()
//                                }
                            }
                        }
                ) {
                    Text(
                        "신청하기",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }



}