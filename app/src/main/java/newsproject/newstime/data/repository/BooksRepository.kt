package newsproject.newstime.data.repository

import io.reactivex.Single
import newsproject.newstime.data.mapper.BooksMappers
import newsproject.newstime.data.source.Api
import newsproject.newstime.domain.model.BooksDetails
import javax.inject.Inject

class BooksRepository @Inject constructor(
    private val api: Api,
    private val booksMappers: BooksMappers
) {
    fun searchBooks(): Single<List<BooksDetails>> {
        return api
            .search("x1y7hXdBYfSjCbbGrNCNnHUHGUP4DJ2a")
            .map { entity ->
                entity.body.map { booksModel ->
                    booksMappers.mapping(booksModel.book_details.first())
                }
            }
    }
}