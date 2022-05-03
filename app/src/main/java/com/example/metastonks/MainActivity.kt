package com.example.metastonks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import coil.compose.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.security.MessageDigest
import retrofit2.create

var detalle_nft = Nft("","")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController=navController, startDestination="main"){
                composable("main"){
                    Start(navController)
                }
                composable("home"){
                    Home(navController)
                }
                composable("login"){
                    Login(navController)
                }
                composable("register"){
                    Register(navController)
                }
                composable("crypto"){
                    Crypto(navController)
                }
                composable("nft"){
                    NFT(navController)
                }
                composable("nft_detalle"){
                    NFTDetalle(detalle_nft, navController)
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
fun Home(navController: NavController){
    Scaffold(
        topBar = { TopAppBarContent(navController, "Inicio 🚀") },
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Column(
                    Modifier
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "MetaStonks",
                        style = MaterialTheme.typography.h2,
                        color = Color.White
                    )
                    Text(
                        text = "Información condensada sobre el mundo del web 3.0",
                        fontSize = 15.sp,
                        color = Color.LightGray
                    )
                    Divider(color = Color.Transparent , thickness = 45.dp)
                    Divider(color = Color.LightGray , thickness = 1.dp)
                    Divider(color = Color.Transparent , thickness = 45.dp)

                    Text(
                            text = "₵rypto",
                    style = MaterialTheme.typography.h2,
                    color = Color.White
                    )
                    Text(
                        text = "\$BTC \$ETH \$USDT \$BNB \$USDC \$XRP \$SOL \$LUNA \$ADA \$UST \$BUSD \$DOGE \$DOT \$AVAX \$SHIB \$STETH \$WBTC \$DAI \$NEAR \$MATIC \$TRX",
                        fontSize = 20.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )

                    // Coingecko
                    Divider(color = Color.Transparent , thickness = 45.dp)
                    Divider(color = Color.LightGray , thickness = 1.dp)
                    Divider(color = Color.Transparent , thickness = 45.dp)
                    Text(
                        text = "💯 WebScrapper",
                        fontSize = 30.sp,
                        color = Color.White
                    )
                    Divider(color = Color.Transparent , thickness = 15.dp)
                    Image(
                        painter = painterResource(R.drawable.coingecko),
                        contentDescription = null
                    )
                    Divider(color = Color.Transparent , thickness = 15.dp)
                    Text(
                        text = "Recopilamos información de coingecko para encontrar los TOKENS más relevantes",
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                    // Reddit
                    Divider(color = Color.Transparent , thickness = 45.dp)
                    Divider(color = Color.LightGray , thickness = 1.dp)
                    Divider(color = Color.Transparent , thickness = 45.dp)
                    Text(
                        text = "📖 MetaScore",
                        fontSize = 30.sp,
                        color = Color.White
                    )
                    Divider(color = Color.Transparent , thickness = 15.dp)
                    Text(
                        text = "Usamos el API de reddit para darte insights de los siguientes foros:",
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Divider(color = Color.Transparent , thickness = 15.dp)
                    Image(
                        painter = painterResource(R.drawable.reddit),
                        contentDescription = null,
                        Modifier
                            .width(60.dp)
                    )
                    Divider(color = Color.Transparent , thickness = 15.dp)
                    Text(
                        text = "\n" +
                                "- r/CryptoCurrency\n" +
                                "- r/Crypto_com\n" +
                                "- r/cryptocurrencymemes\n" +
                                "- r/SatoshiStreetBets\n" +
                                "- r/CryptoMarkets\n",
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    // Reddit
                    Divider(color = Color.Transparent , thickness = 45.dp)
                    Divider(color = Color.LightGray , thickness = 1.dp)
                    Divider(color = Color.Transparent , thickness = 45.dp)
                    Text(
                        text = "¿Cómo calculamos nuestros resultados?",
                        fontSize = 25.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Divider(color = Color.Transparent , thickness = 15.dp)
                    Image(
                        painter = painterResource(R.drawable.score),
                        contentDescription = null,
                        Modifier
                            .fillMaxWidth()
                    )
                }
            }
        },
        backgroundColor = Color(0xFF1F1F1F)
    )
}

@Composable
fun Crypto(navController: NavController){
    Scaffold(
        topBar = { TopAppBarContent(navController, "Crypto 🚀") },
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){

                Column() {
                    Divider(color = Color.Transparent , thickness = 20.dp)
                    Row(
                        Modifier
                            .background(Color.DarkGray)
                            .fillMaxWidth()
                    ){
                        Text(
                            text = "\$BTC",
                            style = MaterialTheme.typography.h5,
                            color = Color.White
                        )
                        Text(
                            text = "[9.7]",
                            style = MaterialTheme.typography.h4,
                            color = Color.Green
                        )
                    }
                    Divider(color = Color.Transparent , thickness = 20.dp)
                }

            }
        },
        backgroundColor = Color(0xFF1F1F1F)
    )
}

@Composable
fun NFT(navController: NavController){
    Scaffold(
        topBar = { TopAppBarContent(navController, "NFT 🚀") },
        content = {
            NftPage(navController)
        },
        backgroundColor = Color(0xFF1F1F1F)
    )
}

@Composable
fun NFTDetalle(data_nft: Nft, navController: NavController){
    Scaffold(
        topBar = { TopAppBarContent(navController, "NFT 🚀") },
        content = {
            details(data_nft)
        },
        backgroundColor = Color(0xFF1F1F1F)
    )
}

@Composable
fun TopAppBarContent(navController: NavController, pTitle: String) {
    val expanded = remember { mutableStateOf(false)}

    TopAppBar(
        title = { Text(text = pTitle, color = Color.White)},
        backgroundColor = Color(0xFF575757),

        actions = {
            Box(
                Modifier
                    .wrapContentSize(Alignment.TopEnd)
            ) {
                IconButton(onClick = {
                    expanded.value = true
                }) {
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "Descr",
                        tint = Color.White
                    )
                }

                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false },
                ) {
                    DropdownMenuItem(onClick = {
                        expanded.value = false
                        navController.navigate("home")
                    }) {
                        Text("Inicio")
                    }

                    Divider()

                    DropdownMenuItem(onClick = {
                        expanded.value = false
                        navController.navigate("crypto")
                    }) {
                        Text("Crypto")
                    }

                    Divider()

                    DropdownMenuItem(onClick = {
                        expanded.value = false
                        navController.navigate("nft")
                    }) {
                        Text("NFTs")
                    }
                }
            }
        }
    )
}

@Composable
fun Login(navController: NavController) {
    val usernameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false)  }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.
                openDialog.value = false
            },
            title = {
                Text(text = "Dialog Title")
            },
            text = {
                Text("Here is a text ")
            },
            confirmButton = {
                Button(

                    onClick = {
                        openDialog.value = false
                    }) {
                    Text("This is the Confirm Button")
                }
            },
            dismissButton = {
                Button(

                    onClick = {
                        openDialog.value = false
                    }) {
                    Text("This is the dismiss Button")
                }
            }
        )
    }

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
                    onClick = {
                        // Logger function
                        if(Loggear(navController, usernameValue.value, passwordValue.value)){
                            println("it works!!!!")
                            navController.navigate("home")
                        }
                              },
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
                    onClick = {
                        if(Registrar(usernameValue.value, passwordValue.value, emailValue.value)){
                            navController.popBackStack()
                        }
                              },
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

fun Loggear(navController: NavController, pUser: String, pPass: String): Boolean{
    println(pUser + "/" + hash(pPass))
    var res = false

    //RETROFIT
    val myApi = RetrofitHelper.getInstance().create(loginApi::class.java)
    GlobalScope.launch {
        val result = myApi.GET_login(pUser,hash(pPass))
        if (result != null){
            if(result.body().toString() == "[OK]"){ // SI EL LOGIN FUE CORRECTO
                res = true
            }
        }
    }

    Thread.sleep(3000L)
    return res
}

fun Registrar(pUser: String, pPass: String, pEmail: String): Boolean{
    println(pUser + " " + hash(pPass) + " " + pEmail)
    //RETROFIT
    if(pUser != "" && pEmail != ""){
        val myApi = RetrofitHelper.getInstance().create(registerApi::class.java)
        GlobalScope.launch {
            val result = myApi.GET_register(pEmail, pUser , hash(pPass))
        }
        Thread.sleep(1000L)
        return true
    }
    else {
        return false
    }
}

// ----------------- NFTs
@Composable
fun NftPage(navController: NavController){
    val tokenAddress = remember { mutableStateOf("") }
    var nft = remember { mutableStateOf(Nft("",""))}
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
                text = "NFTs",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = Color.White
            )

            Text(
                text = "Información condensada sobre el mundo del web 3.0",
                fontSize = 10.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = tokenAddress.value,
                    onValueChange = { tokenAddress.value = it },
                    label = {
                        Text(
                            text = "Token address",
                            style = TextStyle(
                                color = Color.White
                            )
                        )
                    },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        cursorColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {
                        detalle_nft = buscarNft(tokenAddress.value)
                        Thread.sleep(1000L)
                        navController.navigate("nft_detalle")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF066FF0)),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(text = "Buscar", fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.padding(20.dp))
                Spacer(modifier = Modifier.padding(20.dp))

            }

        }
    }
}

data class Nft(var rarity:String, var image:String)

fun buscarNft(address: String): Nft{
    //RETROFIT
    var response = Nft("","")
    val myApi = RetrofitHelper.getInstance().create(nftApi::class.java)
    CoroutineScope(Dispatchers.IO).launch {
        val result = myApi.GET_nft(address)
        response.rarity = result.body()?.get(0).toString()
        response.image = result.body()?.get(1).toString()
    }
    return response
}

@Composable
fun details(nft:Nft){
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
                text = "NFTs",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = Color.White
            )

            Text(
                text = "Información condensada sobre el mundo del web 3.0",
                fontSize = 10.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = nft.image,
                    contentDescription = "description of the image"
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "Rarity",
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = nft.rarity,
                    color = Color.White,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Button(
                    onClick = {
                        //regresar a captura (pantalla anterior)
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF066FF0)),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(text = "Volver a buscar", fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.padding(20.dp))
                Spacer(modifier = Modifier.padding(20.dp))

            }

        }
    }
}