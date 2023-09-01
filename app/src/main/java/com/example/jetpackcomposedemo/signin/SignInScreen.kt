package com.example.jetpackcomposedemo.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.utils.EmailFieldState
import com.example.jetpackcomposedemo.utils.PasswordFieldState
import com.example.jetpackcomposedemo.utils.TextFieldState

@Composable
fun SignInScreen(OnSignInClicked: (email: String, password: String) -> Unit) {


    var isChecked by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_placeholder),
            contentDescription = "logo"
        )
        Spacer(modifier = Modifier.height(15.dp))
        val emailState by remember { mutableStateOf(EmailFieldState()) }
        val passwordState by remember {
            mutableStateOf(PasswordFieldState())
        }
        //  var emailState: TextFieldState = remember { EmailTextInput() },

        EmailTextInput(emailState)
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextInput(passwordState)
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.align(Alignment.Start)
        ) {
            // The button is positioned to the left of the layout
            Text(
                text = "Forgot Password?",
                color = Color(0xFF979797),
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
        Row() {
            Checkbox(
                checked = isChecked, onCheckedChange = { isChecked = it },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFF2EDC83))
            )
            Column() {
                Text(text = "Remember me", color = Color(0xFF2C2C2C))
                Text(text = "Save my login credentials", color = Color(0xFF979797))
            }
        }
        val signUpViewModel: SignInViewModel = viewModel(factory = SignInViewModelFactory())

        Button(
            onClick = {
                signUpViewModel.doLogin()
                if (signUpViewModel.loginResponse.isSuccess == true)
                    OnSignInClicked(emailState.text, "")
            },
            modifier = Modifier
                .padding(1.dp).height(50.dp),
            enabled = emailState.isValid && passwordState.isValid,
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2EDC83)),
        ) {
            if (signUpViewModel.isLoading) {
                CircularProgressIndicator(color = Color.Cyan)
            } else {
                Text(
                    text = "Login",
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextInput(emailState: TextFieldState = remember { EmailFieldState() }) {

    OutlinedTextField(
        value = emailState.text,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color(0xFFF6F6F6),
            unfocusedBorderColor = Color(0xFF979797),
            focusedBorderColor = Color(0xFF979797)
        ),
        label = {
            Text(
                text = "Enter email",
                color = Color(0xFFD9D9D9)
            )
        },
        onValueChange = {
            emailState.text = it
        },
        shape = RoundedCornerShape(5.dp),
        isError = emailState.showErrors()
    )
    emailState.showError()?.let { error ->
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = error, style = TextStyle(
                    color = Color.Red
                )
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextInput(
    passwordFieldState: TextFieldState = remember {
        PasswordFieldState()
    }
) {

    OutlinedTextField(value = passwordFieldState.text,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color(0xFFF6F6F6),
            unfocusedBorderColor = Color(0xFF979797),
            focusedBorderColor = Color(0xFF979797)
        ),
        label = {
            Text(
                text = "Enter password",
                color = Color(0xFFD9D9D9)
            )
        }, onValueChange = { it ->
            passwordFieldState.text = it
        },
        shape = RoundedCornerShape(5.dp)
    )
    passwordFieldState.showError()?.let { error ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = error, style = TextStyle(
                    color = Color.Red
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewSignIn() {
    SignInScreen(OnSignInClicked = { _, _ ->

    })
}

