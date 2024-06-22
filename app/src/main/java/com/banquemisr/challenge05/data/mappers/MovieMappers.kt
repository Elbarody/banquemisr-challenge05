package com.banquemisr.challenge05.data.mappers

import com.banquemisr.challenge05.data.entity.MovieListItem
import com.banquemisr.challenge05.data.local.MovieEntity
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import com.banquemisr.challenge05.data.local.PopularMovie
import com.banquemisr.challenge05.data.local.UpcomingMovie

fun MovieListItem.toMovieNowPlayingEntity(): NowPlayingMovie {
    return NowPlayingMovie(
        id = id, title = title, releaseDate = releaseDate, image = image
    )
}

fun MovieListItem.toPopularMovieEntity(): PopularMovie {
    return PopularMovie(
        id = id, title = title, releaseDate = releaseDate, image = image
    )
}

fun MovieListItem.toUpcomingMovieEntity(): UpcomingMovie {
    return UpcomingMovie(
        id = id, title = title, releaseDate = releaseDate, image = image
    )
}


fun MovieEntity.toMovie(): MovieListItem {
    return MovieListItem(
        id = id, title = title, releaseDate = releaseDate, image = image
    )
}
