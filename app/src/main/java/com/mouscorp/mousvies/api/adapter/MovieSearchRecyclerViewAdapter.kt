package com.mouscorp.mousvies.api.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mousvies.DescriptionActivity
import com.mouscorp.mousvies.R
import com.mouscorp.mousvies.api.models.Movie
import com.mouscorp.mousvies.ui.notifications.NotificationsFragment
import com.mouscorp.mousvies.view.MovieSearchViewHolder
import com.squareup.picasso.Picasso


class MovieSearchRecyclerViewAdapter(
    private val context: NotificationsFragment,
    private val movieList: ArrayList<Movie>

) : RecyclerView.Adapter<MovieSearchViewHolder>() {

    companion object{
        const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSearchViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_movie_search,
            parent,
            false
        )
        return MovieSearchViewHolder(v)
    }

    override fun onBindViewHolder(holder: MovieSearchViewHolder, position: Int) {
        var currentMovie : Movie = movieList[position]
        var image : String
        if (currentMovie.posterPath == null){
            image = currentMovie.backdropPath
        }else{
            image = currentMovie.posterPath
        }
        var movieImagePath : String = MovieSearchRecyclerViewAdapter.BASE_URL_IMAGE + image
        var movieTitle : String = currentMovie.title
        var movieNote : Number = currentMovie.vote_average
        var movieId: Int = currentMovie.id



        holder.movieTitle.text = movieTitle
        holder.movieAverage.text = movieNote.toString()
        holder.movieId.text = movieId.toString()
        // Affiche en ligne de commande url de l'image
        Log.v("imagePath", movieImagePath)

        // Telechargement d'une image a partir d'une url
        // Reduction de la taille de l'image
        Picasso.get()
            .load(movieImagePath)
            .fit()
            .centerInside()
            .into(holder.movieImage)


        holder.movieImage.setOnClickListener(View.OnClickListener { // Init new intend and pass the movie ID data
            val intent: Intent = Intent(context.activity, DescriptionActivity::class.java).apply {
                putExtra("MovieId", movieId)
            }

            // Start the new movie detail activity
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}