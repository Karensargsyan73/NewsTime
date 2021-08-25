package newsproject.newstime.domain.usecase

import io.reactivex.Single
import newsproject.newstime.data.entity.AccountDetails
import newsproject.newstime.data.repository.AccountRepository
import javax.inject.Inject

class AccountUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    fun createAccount(): Single<AccountDetails> = accountRepository.accountDetails()
}