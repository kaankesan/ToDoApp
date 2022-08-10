package com.kaankesan.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kaankesan.todoapp.navigation.Destinations.listComposable
import com.kaankesan.todoapp.navigation.Destinations.taskComposable
import com.kaankesan.todoapp.ui.theme.viewModel.SharedViewModel
import com.kaankesan.todoapp.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
){
    val screen = remember(navController){
        Screens(navController =  navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN){
        listComposable(
            navigateToTaskScreen = screen.task,
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}