package com.mouscorp.mouvies.api.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mouvies.R
import com.mouscorp.mouvies.api.models.Movie
import com.mouscorp.mouvies.view.MovieViewHolder
import com.squareup.picasso.Picasso

class MovieRecyclerViewAdapter (
    private val context : Context,
    private val movieList : ArrayList<Movie>
): RecyclerView.Adapter<MovieViewHolder>(){

    companion object{
        const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500"
    }

    // Cree une vue de film
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        // Retourne une vue basee pour la recherche de film
        val v : View = LayoutInflater.from(context).inflate(R.layout.fragment_movie, parent, false)
        return MovieViewHolder(v)
    }

    // Remplace le contenu de la vue
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var currentMovie : Movie = movieList[position]
        var image : String
        if (currentMovie.posterPath == null){
            image = currentMovie.backdropPath
        }else{
            image = currentMovie.posterPath
        }
        var movieImagePath : String = BASE_URL_IMAGE + image
        var movieTitle : String = currentMovie.title
        var movieNote : Number = currentMovie.vote_average

        holder.movieTitle.text = movieTitle
        holder.movieNote.text = movieNote.toString()
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

    @Override
    override fun getItemCount(): Int {
        return movieList.size
    }

}