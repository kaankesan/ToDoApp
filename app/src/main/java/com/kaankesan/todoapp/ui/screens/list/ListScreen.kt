package com.kaankesan.todoapp.ui.screens.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.kaankesan.todoapp.R
import com.kaankesan.todoapp.ui.theme.fabBackGroundColor
import com.kaankesan.todoapp.ui.theme.viewModel.SharedViewModel

@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit,
){


    Scaffold(
        topBar = {
            ListAppBar(

            ) },
        content = {
            LazyColumn(contentPadding = it){

            }
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
){
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackGroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.Add_Button),
            tint = Color.White
        )
    }
}

