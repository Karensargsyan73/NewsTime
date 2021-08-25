package newsproject.newstime.ui.details

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import newsproject.newstime.R
import newsproject.newstime.domain.model.BooksDetails
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    companion object {
        const val DETAILS_KEY = "details_key"

        fun newInstance(details: BooksDetails): DetailsFragment {
            val detailsFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putSerializable(DETAILS_KEY, details)
            detailsFragment.arguments = bundle
            return detailsFragment
        }
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val detailsViewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val details:BooksDetails = (arguments?.getSerializable(DETAILS_KEY)
            ?: throw IllegalAccessException("no details")) as BooksDetails
        detailsViewModel.init(details)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsViewModel.setDetailsBook.observe(viewLifecycleOwner) { books ->
            books ?: return@observe
        }
    }
}