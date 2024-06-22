import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.RemoteMediator
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import com.banquemisr.challenge05.data.local.NowPlayingMoviesDao
import com.banquemisr.challenge05.data.local.PopularMovie
import com.banquemisr.challenge05.data.local.PopularMoviesDao
import com.banquemisr.challenge05.data.local.UpcomingMovie
import com.banquemisr.challenge05.data.local.UpcomingMoviesDao
import com.banquemisr.challenge05.data.remote.mediator.NowPlayingMoviesRemoteMediator
import com.banquemisr.challenge05.data.remote.mediator.PopularMoviesRemoteMediator
import com.banquemisr.challenge05.data.remote.mediator.UpcomingMoviesRemoteMediator
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class MoviesListRepoImp(
    private val popularMoviesRemoteMediator: PopularMoviesRemoteMediator,
    private val upcomingMoviesRemoteMediator: UpcomingMoviesRemoteMediator,
    private val upcomingMoviesDao: UpcomingMoviesDao,
    private val popularMoviesDao: PopularMoviesDao,
) : MoviesListRepo {



    override fun getPopularMoviesList(): Flow<PagingData<PopularMovie>> =
        createPagerForMovies(popularMoviesRemoteMediator) {
            popularMoviesDao.getPopularMovies()
        }

    override fun getUpcomingMoviesList(): Flow<PagingData<UpcomingMovie>> =
        createPagerForMovies(upcomingMoviesRemoteMediator) {
            upcomingMoviesDao.getUpcomingMovies()
        }

    override fun <T : Any> createPagerForMovies(
        remoteMediator: RemoteMediator<Int, T>,
        pagingSourceFactory: () -> PagingSource<Int, T>
    ): Flow<PagingData<T>> =
        createPager(remoteMediator, pagingSourceFactory)

    private fun <T : Any> createPager(
        remoteMediator: RemoteMediator<Int, T>,
        pagingSourceFactory: () -> PagingSource<Int, T>
    ): Flow<PagingData<T>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            prefetchDistance = 2
        ),
        remoteMediator = remoteMediator,
        pagingSourceFactory = pagingSourceFactory
    ).flow
}
