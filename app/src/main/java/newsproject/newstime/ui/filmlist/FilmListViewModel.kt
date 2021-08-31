package newsproject.newstime.ui.filmlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import newsproject.newstime.domain.model.FilmsModel
import newsproject.newstime.domain.usecase.AccountUseCase
import newsproject.newstime.domain.usecase.FilmsUseCase
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val accountUseCase: AccountUseCase,
    private val filmsUseCase: FilmsUseCase,
    private val router: Router
) : ViewModel() {

    val setFilms = MutableLiveData<List<FilmsModel>>()

    private var accountDisposable = CompositeDisposable()
    private var filmsDisposable = CompositeDisposable()

    init {
        loadAccount()
        loadListFilm()
    }

    fun onFilmClick(details: FilmsModel) {
//        router.navigateTo(Screens.details(details))
    }

    private fun loadAccount() {
        accountDisposable.add(
            accountUseCase.createAccount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {

                    },
                    {
                        it.printStackTrace()
                        println()
                    }
                )
        )
    }

    private fun loadListFilm() {
        filmsDisposable.add(
            filmsUseCase.searchListFilms("Потерянный", "ru-ru")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { films ->
                        setFilms.value = films
                        println()
                    },
                    {
                        it.printStackTrace()
                        println()
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        accountDisposable.dispose()
        filmsDisposable.dispose()
    }
}