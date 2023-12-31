package com.example.myapplication.screens

import android.util.Log
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
fun MainScreen(navController: NavController){
    var companyName by remember { mutableStateOf("")}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F4E8))
    ){
        Spacer(modifier = Modifier.size(60.dp))

        Image(
            painter = painterResource(id = R.drawable.sokdak),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)

        )
        Text(
            "속닥속닥",
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.size(6.dp))
        Text(
            "알고싶은 정보를 솔직하게",
            fontSize = 12.sp
        )
        Spacer(modifier= Modifier.size(8.dp))
        OutlinedTextField(
            value = companyName,
            onValueChange = {newValue ->
                companyName = newValue

            },
            label = {
                Text(
                    "기업 이름을 입력해 주세요",
                    fontSize = 14.sp
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            modifier = Modifier
                .width(250.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(4.dp)),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 14.sp
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            "혹시 찾으시는 기업이 없나요?",
            fontSize = 10.sp,
            color = Color.Gray,
            modifier = Modifier
                .clickable {
                    navController.navigate("companyRegisteration")
                }
        )
    }
}