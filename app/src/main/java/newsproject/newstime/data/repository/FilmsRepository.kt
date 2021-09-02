package newsproject.newstime.data.repository

import io.reactivex.Single
import newsproject.newstime.BuildConfig
import newsproject.newstime.data.mapper.FilmsMapper
import newsproject.newstime.data.source.Api
import newsproject.newstime.domain.model.FilmsModel
import javax.inject.Inject

class FilmsRepository @Inject constructor(
    private val api: Api,
    private val filmsMapper: FilmsMapper
) {
    fun searchFilms(query: String, language: String): Single<List<FilmsModel>> {
        return api
            .searchFilms(query, language, BuildConfig.API_KEY)
            .map{ entity ->
            entity.results.map {
                filmsMapper.filmsMapping(it)
            }
        }
    }
}