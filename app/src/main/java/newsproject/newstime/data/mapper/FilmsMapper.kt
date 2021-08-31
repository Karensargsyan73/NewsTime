package newsproject.newstime.data.mapper

import newsproject.newstime.data.entity.films.FilmResult
import newsproject.newstime.domain.model.FilmsModel
import javax.inject.Inject

class FilmsMapper @Inject constructor() {

    fun filmsMapping(entity: FilmResult): FilmsModel =
        FilmsModel(
            id = entity.id,
            originalLanguage = entity.original_language,
            originalTitle = entity.original_title,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.poster_path,
            releaseDate = entity.release_date,
            title = entity.title
        )
}