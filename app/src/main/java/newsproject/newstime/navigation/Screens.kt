package newsproject.newstime.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import newsproject.newstime.domain.model.BooksDetails
import newsproject.newstime.domain.model.FilmsModel
import newsproject.newstime.ui.details.DetailsFragment
import newsproject.newstime.ui.filmlist.FilmListFragment

object Screens {

    //    fun books() = FragmentScreen { BooksFragment() }
    fun details(details: BooksDetails) = FragmentScreen { DetailsFragment.newInstance(details) }
    fun filmListScreen() = FragmentScreen { FilmListFragment() }
}