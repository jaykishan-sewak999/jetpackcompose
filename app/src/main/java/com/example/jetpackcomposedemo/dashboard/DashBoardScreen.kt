package com.example.jetpackcomposedemo.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DashBoardScreen(message: String) {

    val usersListViewModel: UsersListViewModel = viewModel(factory = UsersListViewModelFactory())

    if (message.contains("guest", ignoreCase = true)) {
        UsersList(users = usersListViewModel.usersListResponse.data, usersListViewModel)

    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome\n$message",
                style = TextStyle(
                    fontSize = 22.sp, color = Color.Green,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W700
                )
            )
        }
    }
}

@Composable
fun UsersList(users: List<DataItem>, usersListViewModel: UsersListViewModel) {

    LaunchedEffect(Unit, block = {
        usersListViewModel.fetchUsers()
    })

    if (usersListViewModel.isLoading) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    color = Color.Cyan,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .align(Alignment.Center)
                )
            }

        }

    } else {
        LazyColumn {
            itemsIndexed(items = users) { index, item ->
                Box(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)) {
                    Column(modifier = Modifier
                        .background(color = Color.LightGray)) {
                        Text(text = item.employeeName ?: "")

                        Text(text = item.employeeSalary.toString())
                        if (index < users.size)
                            Divider(color = Color.Gray, thickness = 1.dp)
                    }
                }

            }
        }
    }
}