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
import newsproject.newstime.domain.usecase.AddFilmUseCase
import newsproject.newstime.domain.usecase.FilmsUseCase
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val accountUseCase: AccountUseCase,
    private val filmsUseCase: FilmsUseCase,
    private val addFilmUseCase: AddFilmUseCase,
    private val router: Router
) : ViewModel() {

    val setFilms = MutableLiveData<List<FilmsModel>>()
    val favoriteFilms = MutableLiveData<List<FilmsModel>>()

    private var filmDisposable = CompositeDisposable()

    init {
        loadAccount()
        loadListFilm()
    }

    fun onFilmClick(film: FilmsModel) {
//        router.navigateTo(Screens.details(details))
        addFilmsFavorite(film.id)
        println()
    }

    private fun loadAccount() {
        filmDisposable.add(
            accountUseCase.createAccount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        println()
                    },
                    {
                        it.printStackTrace()
                        println()
                    }
                )
        )
    }

    private fun loadListFilm() {
        filmDisposable.add(
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

    fun addFilmsFavorite(filmId: Int) {
        filmDisposable.add(
            addFilmUseCase.addFilmFavorite("ru-ru", filmId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
//                        addFilmUseCase.addFilmFavorite("ru-ru", filmId)
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
        filmDisposable.dispose()
    }
}