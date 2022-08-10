package com.kaankesan.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kaankesan.todoapp.di.DatabaseModule.provideDatabase
import com.kaankesan.todoapp.navigation.SetupNavigation
import com.kaankesan.todoapp.ui.theme.ToDoAppTheme
import com.kaankesan.todoapp.ui.theme.viewModel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                navController = rememberNavController()
                SetupNavigation(
                    navController = navController,
                )
            }

        }


    }




}
