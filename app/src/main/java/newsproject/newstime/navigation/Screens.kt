package newsproject.newstime.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import newsproject.newstime.ui.filmlist.FilmListFragment

object Screens {
    fun filmListScreen() = FragmentScreen { FilmListFragment() }
//    fun details(details: BooksDetails) = FragmentScreen { DetailsFragment.newInstance(details) }
}