package com.banquemisr.challenge05.presenter

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.banquemisr.challenge05.presenter.movieslist.MoviesListViewModel
import com.banquemisr.challenge05.presenter.movieslist.MoviesListWithTabScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            val movieViewModel : MoviesListViewModel = koinViewModel()

            MoviesListWithTabScreen(
                viewModel=movieViewModel,
                onNavigateToMyScreen = { navController.navigate("myScreen") }
            )
        }
        /*composable("myScreen") {
            MyScreen()
        }*/
    }
}