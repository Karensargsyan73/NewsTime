package newsproject.newstime.domain.model

import java.io.Serializable

data class BooksDetails(
    val ageGroup: String,
    val amazonProductUrl: String,
    val author: String,
    val bookImage: String,
    val bookUri: String,
    val contributor: String,
    val contributor_note: String,
    val description: String,
    val price: String,
    val primary_isbn10: String,
    val primary_isbn13: String,
    val publisher: String,
    val title: String
) : Serializable