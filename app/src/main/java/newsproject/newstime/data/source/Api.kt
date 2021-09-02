package newsproject.newstime.data.source

import io.reactivex.Single
import newsproject.newstime.data.entity.AccountDetails
import newsproject.newstime.data.entity.films.FilmsModelEntity
import newsproject.newstime.domain.model.FilmIdRequest
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @GET("account")
    fun accountApi(
        @Query("session_id") sessionId: String,
    ): Single<AccountDetails>

    @GET("search/movie")
    fun searchFilms(
        @Query("query") query: String,
        @Query("language") language: String,
        @Query("api_key") apiKey: String
    ): Single<FilmsModelEntity>

    @POST("list/7104584/add_item")
    fun addFavorite(
        @Query("language") language: String,
        @Query("session_id") sessionId: String,
        @Body addFavoriteRequest: FilmIdRequest
    ): Single<ResponseBody>
}