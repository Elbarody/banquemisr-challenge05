import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.RemoteMediator
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class MoviesListRepoImp : MoviesListRepo {

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
