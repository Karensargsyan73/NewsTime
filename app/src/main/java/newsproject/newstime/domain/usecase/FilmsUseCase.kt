package newsproject.newstime.domain.usecase

import io.reactivex.Single
import newsproject.newstime.data.repository.FilmsRepository
import newsproject.newstime.domain.model.FilmsModel
import javax.inject.Inject

class FilmsUseCase @Inject constructor(
    private val filmsRepository: FilmsRepository
) {
    fun searchListFilms(query: String, language: String): Single<List<FilmsModel>> =
        filmsRepository.searchFilms(query, language)
}