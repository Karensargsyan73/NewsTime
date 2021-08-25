package newsproject.newstime.data.entity


class BooksModelEntity(
    val asterisk: Int,
    val bestsellers_date: String,
    val book_details: List<BookDetailEntity>,
    val dagger: Int,
    val display_name: String,
    val list_image: Any,
    val list_image_height: Any,
    val list_image_width: Any,
    val list_name: String,
    val list_name_encoded: String,
    val normal_list_ends_at: Int,
    val published_date: String,
    val published_date_range: String,
    val rank: Int,
    val rank_last_week: Int,
    val reviews: List<ReviewEntity>,
    val updated: String,
    val weeks_on_list: Int
)