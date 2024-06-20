package com.banquemisr.challenge05.presenter

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.banquemisr.challenge05.presenter.moviedetails.MovieDetailsScreen
import com.banquemisr.challenge05.presenter.moviedetails.MoviesDetailsViewModel
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
                onNavigateToMovieDetails = { movieId ->
                    navController.navigate("movieDetails/$movieId")
                }
            )
        }

        composable(
            "movieDetails/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")
            val movieDetailsViewModel: MoviesDetailsViewModel = koinViewModel()
            movieId?.let { MovieDetailsScreen(movieId = it, viewModel = movieDetailsViewModel){
                navController.popBackStack()
            } }
        }
    }
}