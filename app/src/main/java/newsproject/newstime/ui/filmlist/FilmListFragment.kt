package newsproject.newstime.ui.filmlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import newsproject.newstime.R

@AndroidEntryPoint
class FilmListFragment : Fragment(R.layout.fragment_list_film) {

    private val filmViewModel: FilmListViewModel by viewModels()
    private val filmListAdapter = FilmListAdapter {
        filmViewModel.onFilmClick(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        filmViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filmsList = view.findViewById<RecyclerView>(R.id.films_list_rv)
        filmsList.adapter = filmListAdapter
        filmsList.layoutManager = LinearLayoutManager(requireContext())

        filmViewModel.setFilms.observe(viewLifecycleOwner) { films ->
            films ?: return@observe
            filmListAdapter.update(films)
        }
    }
}