package newsproject.newstime.data.source

import io.reactivex.Single
import newsproject.newstime.data.entity.AccountDetails
import newsproject.newstime.data.entity.books.BaseModelEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface
Api {
    @GET("lists/current/hardcover-fiction.json")
    fun search(
        @Query("api-key") apiKey: String,
    ): Single< BaseModelEntity>

    @GET("account")
    fun account(
        @Query("session_id") sessionId: String,
    ): Single<AccountDetails>
}