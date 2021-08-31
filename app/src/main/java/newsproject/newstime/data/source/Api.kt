package newsproject.newstime.data.source

import io.reactivex.Single
import newsproject.newstime.data.entity.AccountDetails
import newsproject.newstime.data.entity.books.BaseModelEntity
import newsproject.newstime.data.entity.films.FilmsModelEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("lists/current/hardcover-fiction.json")
    fun searchApi(
        @Query("api_key") apiKey: String,
    ): Single<BaseModelEntity>

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
}