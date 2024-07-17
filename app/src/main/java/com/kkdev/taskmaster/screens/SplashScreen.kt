package com.kkdev.taskmaster.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkdev.taskmaster.MainActivity
import com.kkdev.taskmaster.R
import com.kkdev.taskmaster.ui.theme.AppTheme
import com.kkdev.taskmaster.ui.theme.poppinsFontFamily
import kotlinx.coroutines.delay


@SuppressLint("CustomSplashScreen")
class SplashActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface (modifier = Modifier.fillMaxSize(), color = AppTheme.colorScheme.background){
                    SplashScreen()
                }

            }
        }
    }
    @Composable
    private fun SplashScreen(){
        LaunchedEffect(key1 = true) {
            delay(2000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        }
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_onboarding),
                contentDescription = null,
                modifier = Modifier.size(200.dp),
            )

            //Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Taskmaster",
                style = MaterialTheme.typography.titleLarge,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold

            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ssp(){
        AppTheme{
            SplashScreen()
        }
    }

}
