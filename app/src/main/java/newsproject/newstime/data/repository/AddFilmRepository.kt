package newsproject.newstime.data.repository

import io.reactivex.Single
import newsproject.newstime.BuildConfig
import newsproject.newstime.data.source.Api
import newsproject.newstime.domain.model.FilmIdRequest
import okhttp3.ResponseBody
import javax.inject.Inject

class AddFilmRepository @Inject constructor(
    private val api: Api
) {

    fun addFilmFavorite(language: String, addFilmId: Int): Single<ResponseBody> {
        val filmModel = FilmIdRequest(addFilmId)

        return api.addFavorite(language, BuildConfig.SESSION_ID, filmModel)
    }
}