package com.kkdev.taskmaster.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkdev.taskmaster.R
import com.kkdev.taskmaster.ui.theme.AppTheme
import com.kkdev.taskmaster.ui.theme.poppinsFontFamily

@Composable
fun WelcomeScreen(
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(){
            val image = painterResource(id = R.drawable.undraw_done_checking_re_6vyx)
            Image(painter = image, contentDescription = null )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Task Management &\n" +
                    "To-Do List",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "This productive tool is designed to help you better manage your task project-wise conveniently!",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppTheme.colorScheme.primary,
                contentColor = AppTheme.colorScheme.onPrimary
            ),
            shape = AppTheme.shape.button,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 5.dp
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier =  Modifier.padding(5.dp)
                ) {
                Text(
                    text = "Let’s Start",
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(20.dp))
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = null,
                    tint = AppTheme.colorScheme.onPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(100.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun wsp(){
    AppTheme{
        WelcomeScreen()
    }
}

