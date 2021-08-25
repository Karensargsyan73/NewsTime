package newsproject.newstime.ui.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import newsproject.newstime.R
import newsproject.newstime.domain.model.BooksDetails

class BooksAdapter(private val clickListener: (BooksDetails) -> Unit) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    private val items = mutableListOf<BooksDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder =
        BooksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false))

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.description.text = item.description
        Glide
            .with(holder.image)
            .load(item.bookImage)
            .into(holder.image)
    }


    override fun getItemCount(): Int = items.size
    fun update(books: List<BooksDetails>) {
        items.clear()
        items.addAll(books)
        notifyDataSetChanged()
    }

    inner class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)


        init {
            view.findViewById<View>(R.id.item_root).setOnClickListener {
                clickListener.invoke(items[adapterPosition])
            }
        }
    }
}