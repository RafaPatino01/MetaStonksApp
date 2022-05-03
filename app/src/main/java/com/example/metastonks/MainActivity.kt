package com.example.metastonks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.security.MessageDigest
import retrofit2.create


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController=navController, startDestination="main"){
                composable("main"){
                    Start(navController)
                }
                composable("login"){
                    Login(navController)
                }
                composable("register"){
                    Register(navController)
                }
            }

        }
    }
}

@Composable
fun Start(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xFF1F1F1F))
    ) {
        Text(text = "MetaStonks🚀",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(bottom = 10.dp)
                .fillMaxWidth(1f)
        )
        Text(text = "Información condensada sobre el mundo del web 3.0",
            color = Color.White,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(bottom = 50.dp)
                .fillMaxWidth(1f)
        )
        Button(
            onClick = {
                      navController.navigate("login")
                      },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxWidth(0.4f),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            // Inner content including an icon and a text label
            Icon(

                Icons.Filled.Person,
                contentDescription = "Ingresar",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Ingresar")
        }


    }
}

@Composable
fun Login(navController: NavController) {
    val usernameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF1F1F1F))
            .padding(10.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "🚀",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )
            Text(
                text = "Iniciar sesión",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = usernameValue.value,
                    onValueChange = { usernameValue.value = it },
                    label = { Text(
                        text ="Usuario",
                        style = TextStyle(
                            color = Color.White
                        )
                    )},
                    textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        cursorColor = Color.White
                    )
                )
                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    label = { Text(
                        text ="Contraseña",
                        style = TextStyle(
                            color = Color.White
                        )
                    )},
                    textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp),

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        cursorColor = Color.White
                    ),

                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)


                )
                Spacer(modifier = Modifier.padding(15.dp))
                Button(
                    onClick = { Loggear(usernameValue.value, passwordValue.value) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF066FF0)),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(50.dp)
                ) {
                    Text(text = "Entrar",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = { navController.navigate("register") },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF7E7E7E)),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(50.dp)
                ) {
                    Text(text = "Registrarse", fontSize = 20.sp, color = Color.White)
                }

                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Register(navController: NavController) {
    val usernameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF1F1F1F))
            .padding(10.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "🚀",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )
            Text(
                text = "Registro",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = usernameValue.value,
                    onValueChange = { usernameValue.value = it },
                    label = { Text(
                        text ="Usuario",
                        style = TextStyle(
                            color = Color.White
                        )
                    )},
                    textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        cursorColor = Color.White
                    )
                )
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    label = { Text(
                        text ="Email",
                        style = TextStyle(
                            color = Color.White
                        )
                    )},
                    textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        cursorColor = Color.White
                    )
                )
                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    label = { Text(
                        text ="Contraseña",
                        style = TextStyle(
                            color = Color.White
                        )
                    )},
                    textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp),

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        cursorColor = Color.White
                    ),

                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)


                )
                Spacer(modifier = Modifier.padding(15.dp))
                Button(
                    onClick = { Registrar(usernameValue.value, passwordValue.value, emailValue.value)},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF066FF0)),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(50.dp)
                ) {
                    Text(text = "Siguiente",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF7E7E7E)),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(50.dp)
                ) {
                    Text(text = "< Regresar",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}

fun hash(p: String): String {
    val bytes = p.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}

fun Loggear(pUser: String, pPass: String){
    println(pUser + "/" + hash(pPass))

    //RETROFIT
    val myApi = RetrofitHelper.getInstance().create(loginApi::class.java)
    GlobalScope.launch {
        val result = myApi.GET_login(pUser,hash(pPass))
        if (result != null)
        // Checking the results
            println("RESULTADO: " + result.body().toString())
    }
}

fun Registrar(pUser: String, pPass: String, pEmail: String){
    println(pUser + " " + hash(pPass) + " " + pEmail)
}