package newsproject.newstime.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import newsproject.newstime.domain.model.BooksDetails
import newsproject.newstime.ui.books.BooksFragment
import newsproject.newstime.ui.details.DetailsFragment

object Screens {

    fun books() = FragmentScreen { BooksFragment() }

    fun details(details: BooksDetails ) = FragmentScreen { DetailsFragment.newInstance(details) }
}