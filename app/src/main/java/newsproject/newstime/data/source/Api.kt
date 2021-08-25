package newsproject.newstime

import io.reactivex.Single
import newsproject.newstime.data.entity.BaseModelEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("lists/current/hardcover-fiction.json")
    fun search(
        @Query("api-key") apiKey: String,
    ): Single<BaseModelEntity>
}