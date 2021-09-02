package newsproject.newstime.data.repository

import android.content.SharedPreferences
import io.reactivex.Single
import newsproject.newstime.BuildConfig
import newsproject.newstime.data.entity.AccountDetails
import newsproject.newstime.data.source.Api
import javax.inject.Inject

const val APP_PREFERENCES_ID = "id"

class AccountRepository @Inject constructor(
    private val api: Api,
    private val preferences: SharedPreferences
) {
    fun accountDetails(): Single<AccountDetails> =
        api
            .accountApi(BuildConfig.SESSION_ID)
            .doOnSuccess { accountDetail ->
                preferences.edit().putLong(APP_PREFERENCES_ID, accountDetail.id).apply()
            }
}