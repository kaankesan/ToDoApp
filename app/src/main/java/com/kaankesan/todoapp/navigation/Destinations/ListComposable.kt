package com.kaankesan.todoapp.navigation.Destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kaankesan.todoapp.ui.screens.list.ListScreen
import com.kaankesan.todoapp.ui.theme.viewModel.SharedViewModel
import com.kaankesan.todoapp.util.Constants.LIST_ARGUMENT_KEY
import com.kaankesan.todoapp.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,

){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
        )
    }
}

