package newsproject.newstime.data.mapper

import newsproject.newstime.data.entity.books.BookDetailEntity
import newsproject.newstime.domain.model.BooksDetails
import javax.inject.Inject

class BooksMappers @Inject constructor() {

    fun mapping(booksDetailsEntity: BookDetailEntity): BooksDetails =
        BooksDetails(
            ageGroup = booksDetailsEntity.age_group,
            amazonProductUrl = booksDetailsEntity.amazon_product_url,
            author = booksDetailsEntity.author,
            bookImage = booksDetailsEntity.book_image,
            bookUri = booksDetailsEntity.book_uri,
            contributor = booksDetailsEntity.contributor,
            contributor_note = booksDetailsEntity.contributor_note,
            description = booksDetailsEntity.description,
            price = booksDetailsEntity.price,
            primary_isbn10 = booksDetailsEntity.primary_isbn10,
            primary_isbn13 = booksDetailsEntity.primary_isbn13,
            publisher = booksDetailsEntity.publisher,
            title = booksDetailsEntity.title
        )
}