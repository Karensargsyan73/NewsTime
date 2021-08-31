package newsproject.newstime.ui.books

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import newsproject.newstime.R

@AndroidEntryPoint
class BooksFragment : Fragment(R.layout.fragment_book) {
    private val booksViewModel: BooksViewModel by viewModels()
    private val booksAdapter = BooksAdapter {
        booksViewModel.onBookClick(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        booksViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val books = view.findViewById<RecyclerView>(R.id.books)
        books.adapter = booksAdapter
        books.layoutManager = LinearLayoutManager(requireContext())

        booksViewModel.setBook.observe(viewLifecycleOwner) { books ->
            books ?: return@observe
            booksAdapter.update(books)
        }
    }
}