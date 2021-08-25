package newsproject.newstime.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import newsproject.newstime.domain.model.BooksDetails
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {
    val setDetailsBook = MutableLiveData<BooksDetails>()

    fun init(details: BooksDetails) {
        setDetailsBook.value = details

    }
}