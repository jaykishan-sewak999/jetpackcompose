package com.example.jetpackcomposedemo.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue

import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavHostController) {
    Column(verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment =Alignment.CenterHorizontally) {
        Text(text = "Login",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.W700
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        EmailTextInput1()
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextInput1("Enter password")
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextInput1("Enter confirm password")
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {  },
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()) {
            Text(text = "Sign up")
        }

        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = { navController.navigate("signIn") },
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()) {
            Text(text = "Login")
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextInput1(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(value = text,
        modifier = Modifier.fillMaxWidth(),
        label = {
                Text(text = "Enter email")
        }, onValueChange = { it ->
        text= it
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextInput1(hint: String){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(value = text,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = hint)
        }, onValueChange = { it ->
            text= it
        })
}
