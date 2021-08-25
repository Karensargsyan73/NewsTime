package newsproject.newstime.domain.usecase

import io.reactivex.Single
import newsproject.newstime.data.repository.BooksRepository
import newsproject.newstime.domain.model.BooksDetails
import javax.inject.Inject

class BooksUseCase @Inject constructor(
    private val booksRepository: BooksRepository
) {
    fun searchBooks(): Single<List<BooksDetails>> = booksRepository.searchBooks()
}