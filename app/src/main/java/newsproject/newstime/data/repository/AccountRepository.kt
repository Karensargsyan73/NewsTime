package newsproject.newstime.data.repository

import io.reactivex.Single
import newsproject.newstime.BuildConfig
import newsproject.newstime.data.entity.AccountDetails
import newsproject.newstime.data.source.Api
import javax.inject.Inject
import javax.inject.Named

class AccountRepository @Inject constructor(
    @Named("accountApi")
    private val api: Api,
) {
    fun accountDetails(): Single<AccountDetails> = api.account(BuildConfig.SESSION_ID)
}