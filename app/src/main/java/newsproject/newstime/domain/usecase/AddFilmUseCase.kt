package newsproject.newstime.domain.usecase

import io.reactivex.Single
import newsproject.newstime.data.repository.AddFilmRepository
import okhttp3.ResponseBody
import javax.inject.Inject

class AddFilmUseCase @Inject constructor(
    private val addFilmRepository: AddFilmRepository
) {
    fun addFilmFavorite(language: String, addFilmId: Int): Single<ResponseBody> {
       return addFilmRepository.addFilmFavorite(language, addFilmId)
    }
}