package com.example.assigment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assigment.ui.theme.AssigmentTheme

class Screen2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeBackScreen()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun WelcomeBackScreen() {
        AssigmentTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(32.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "BookStore Xin Chào!",
                        fontSize = 24.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold

                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = "Email", fontFamily = FontFamily.Monospace) },
                        shape = RoundedCornerShape(8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Password",
                                fontFamily = FontFamily.Monospace
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(8.dp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { /* Perform login action */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Log in")
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Forgot Password",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = Color.Black,
                        fontSize = 16.sp,

                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        text = "Sign Up",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}