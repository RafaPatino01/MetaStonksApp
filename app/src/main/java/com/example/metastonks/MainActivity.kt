package com.example.metastonks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.metastonks.ui.theme.MetaStonksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetaStonksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Column {
        Text(text = "Hello World")
    }
}

@Composable
fun StonkButton(pText: String){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = ButtonDefaults.elevation(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    ) {
        Text(text = pText)
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreen() {
    MetaStonksTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 128.dp)
                    .padding(horizontal = 64.dp)
                    .fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.welcome), contentDescription = null)
                Column(
                    modifier = Modifier
                        .padding(vertical = 32.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    StonkButton("Log In")
                    StonkButton("Sign Up")
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Image(painter = painterResource(id = R.drawable.rocket), contentDescription = null)
            }
        }
    }
}