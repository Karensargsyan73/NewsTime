package newsproject.newstime.ui.filmlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import newsproject.newstime.R
import newsproject.newstime.domain.model.FilmsModel

class FilmListAdapter(private val clickListener: (FilmsModel) -> Unit) :
    RecyclerView.Adapter<FilmListAdapter.FilmListViewHolder>() {
    private val films = mutableListOf<FilmsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder =
        FilmListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false))

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        val item = films[position]
        holder.title.text = item.title
        holder.description.text = item.overview
        Glide
            .with(holder.image)
            .load("https://image.tmdb.org/t/p/original${item.posterPath}")
            .into(holder.image)
    }

    override fun getItemCount(): Int = films.size

    fun update(filmsList: List<FilmsModel>) {
        films.clear()
        films.addAll(filmsList)
        notifyDataSetChanged()
    }

    inner class FilmListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.film_title)
        val image: ImageView = view.findViewById(R.id.film_image)
        val description: TextView = view.findViewById(R.id.film_description)


        init {
            view.findViewById<View>(R.id.item_film_root).setOnClickListener {
                clickListener.invoke(films[adapterPosition])
            }
        }
    }
}