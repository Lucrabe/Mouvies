package com.mouscorp.mousvies.api.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mousvies.DescriptionActivity
import com.mouscorp.mousvies.R
import com.mouscorp.mousvies.api.models.MovieDetails
import com.mouscorp.mousvies.view.MovieDetailsViewHolder
import com.squareup.picasso.Picasso

class MovieDetailsRecyclerViewAdapter(
    private val context: DescriptionActivity,
    private val movieDetails: MovieDetails?
): RecyclerView.Adapter<MovieDetailsViewHolder>() {

    companion object{
        const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDetailsViewHolder {

        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_movie_details, parent, false)
        return MovieDetailsViewHolder(v)
    }

    override fun onBindViewHolder(holder: MovieDetailsViewHolder, position: Int) {

        var currentMovie : MovieDetails? = movieDetails

        var movieImagePath : String = BASE_URL_IMAGE + currentMovie!!.poster_path
        var movieTitle : String = currentMovie.title
        var movieNote : Number = currentMovie.vote_average
        var movieDesc : String? = currentMovie.overview

        holder.movieTitle.text = movieTitle
        holder.movieNote.text = "Note : "+movieNote.toString()+" /10"
        holder.movieDescription.text = movieDesc
        // Affiche en ligne de commande url de l'image
        Log.v("imagePath", movieImagePath)

        // Telechargement d'une image a partir d'une url
        // Reduction de la taille de l'image
        Picasso.get()
            .load(movieImagePath)
            .fit()
            .centerInside()
            .into(holder.movieImage)
    }

    override fun getItemCount(): Int {
        var num : Int = 1
        return num
    }
}