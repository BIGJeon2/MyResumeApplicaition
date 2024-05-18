package com.jeon.myresumeapplicaition

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeon.myresumeapplicaition.ui.theme.MyResumeApplicaitionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyResumeApplicaitionTheme {
                // A surface container using the 'background' color from the theme
                myResume()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun myResume(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Android Native Developer",
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            )
        },

    ) { paddingValues ->
        myContent(paddingValues)

    }
}

@Composable
private fun myContent(paddingValues: PaddingValues){

    val context: Context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.test_image),
                contentDescription = "profile",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Introduce",
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "안녕하세요. 2년차 Native개발자 전희태 입니다.",
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "개발을 하고 있습니다.",
                color = Color.Blue,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Divider(color = Color.Gray, thickness = 1.dp)

            Text(
                text = "Phone Num : 010-1234-5678",
                color = Color.Gray,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(10.dp)
            )

            Text(
                text = "E-Mail : myresume@practice.com",
                color = Color.Gray,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(10.dp)
            )

            Button(
                onClick = {
                    val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01040376728"))
                    context.startActivity(callIntent)
                          },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
              Text(text = "Call")
            }

            Button(
                onClick = {
                    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:robert6728@naver.com")
                    }
                    context.startActivity(emailIntent)
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Send Email")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyResumeApplicaitionTheme {
        myResume()
    }
}