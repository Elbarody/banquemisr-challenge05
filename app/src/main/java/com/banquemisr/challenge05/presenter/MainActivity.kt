package com.banquemisr.challenge05.presenter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.banquemisr.challenge05.presenter.movieslist.MoviesListWithTabScreen
import com.banquemisr.challenge05.utility.uitheme.MovieComposeTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieComposeTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}