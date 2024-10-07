package com.example.hirenext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hirenext.screen.AgreementScreen
import com.example.hirenext.screen.ChatScreen
import com.example.hirenext.screen.HomeScreen
import com.example.hirenext.screen.LoginScreen
import com.example.hirenext.screen.SignUpScreen
import com.example.hirenext.screen.UpdateScreen
import com.example.hirenext.ui.theme.HireNextTheme

sealed class Screen(val route: String){
    object LoginScreen: Screen("login_screen")
    object SignUpScreen: Screen("sign_up_screen")
    object HomeScreen: Screen("home_screen")
    object ChatScreen: Screen("chat_screen")
    object UpdateScreen: Screen("update_screen")
    object AgreementScreen: Screen("agreement_screen")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HireNextTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                      Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation(){
    val navController =rememberNavController()

    NavHost(navController = navController, startDestination =Screen.SignUpScreen.route) {
       composable(Screen.LoginScreen.route){
           LoginScreen()
       }
        composable(Screen.SignUpScreen.route){
            SignUpScreen()
       }
        composable(Screen.HomeScreen.route){
            HomeScreen()
        }
        composable(Screen.ChatScreen.route){
            ChatScreen()
        }
        composable(Screen.UpdateScreen.route){
            UpdateScreen()
            }
        composable(Screen.AgreementScreen.route){
            AgreementScreen()
        }



    }
}
