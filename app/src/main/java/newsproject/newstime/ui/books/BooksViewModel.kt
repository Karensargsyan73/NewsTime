package newsproject.newstime.ui.books

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io
import newsproject.newstime.data.entity.AccountDetails
import newsproject.newstime.domain.model.BooksDetails
import newsproject.newstime.domain.usecase.AccountUseCase
import newsproject.newstime.domain.usecase.BooksUseCase
import newsproject.newstime.navigation.Screens
import javax.inject.Inject

const val APP_PREFERENCES = "mySettings"
const val APP_PREFERENCES_ID = "id"

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val useCase: BooksUseCase,
    private val accountUseCase: AccountUseCase,
    private val router: Router,
    private val preferences: SharedPreferences
) : ViewModel() {

    val setBook = MutableLiveData<List<BooksDetails>>()
    private val setAccount = MutableLiveData<AccountDetails>()

    private var disposable = CompositeDisposable()
    private var accountDisposable = CompositeDisposable()

    init {
        loadsBooks()
        loadsAccount()
    }

    fun onBookClick(details: BooksDetails) {
        router.navigateTo(Screens.details(details))
    }


    private fun loadsBooks() {
        disposable.add(
            useCase.searchBooks()
                .subscribeOn(io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { books ->
                        setBook.value = books
                        println()
                    },
                    { th ->
                        th.printStackTrace()
                    }
                )
        )
    }

    private fun loadsAccount() {
        accountDisposable.add(
            accountUseCase.createAccount()
                .subscribeOn(io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { accountDetails ->
                        setAccount.value = accountDetails
                        putSharedPref(accountDetails.id)
                        println()
                    },
                    {
                        it.printStackTrace()
                        println()
                    }
                )
        )
    }

    private fun putSharedPref(id: Long?) {
        preferences.edit().putLong(APP_PREFERENCES_ID, id!!).apply()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
        accountDisposable.dispose()
    }
}