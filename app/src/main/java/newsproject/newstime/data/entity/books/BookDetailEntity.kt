package newsproject.newstime.data.entity.books

import java.io.Serializable

class BookDetailEntity (
    val age_group: String,
    val amazon_product_url: String,
    val author: String,
    val book_image: String,
    val book_uri: String,
    val contributor: String,
    val contributor_note: String,
    val description: String,
    val price: String,
    val primary_isbn10: String,
    val primary_isbn13: String,
    val publisher: String,
    val title: String
    ):Serializable