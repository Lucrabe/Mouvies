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
import com.mouscorp.mousvies.ui.dashboard.DashboardFragment
import com.mouscorp.mousvies.ui.home.HomeFragment
import com.mouscorp.mousvies.view.MoviePopularViewHolder
import com.mouscorp.mousvies.view.MovieViewHolder
import com.squareup.picasso.Picasso

class MoviePopularRecyclerViewAdapter(
    private val context: HomeFragment,
    private val movieList: ArrayList<Movie>
): RecyclerView.Adapter<MoviePopularViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePopularViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_movie, parent, false)
        return MoviePopularViewHolder(v)
    }

    // Remplace le contenu de la vue
    override fun onBindViewHolder(holder: MoviePopularViewHolder, position: Int) {
        var currentMovie : Movie = movieList[position]
        var image : String
        if (currentMovie.posterPath == null){
            image = currentMovie.backdropPath
        }else{
            image = currentMovie.posterPath
        }
        var movieImagePath : String = MovieRecyclerViewAdapter.BASE_URL_IMAGE + image
        var movieTitle : String = currentMovie.title
        var movieNote : Number = currentMovie.vote_average

        holder.movieTitle.text = movieTitle
        holder.movieNote.text = "Note : "+movieNote.toString()+" /10"
        // Affiche en ligne de commande url de l'image
        Log.v("imagePath", movieImagePath)

        // Telechargement d'une image a partir d'une url
        // Reduction de la taille de l'image
        Picasso.get()
            .load(movieImagePath)
            .fit()
            .centerInside()
            .into(holder.movieImage)

        holder.movieImage.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(context.activity, DescriptionActivity::class.java).apply {
                putExtra("MovieId", currentMovie.id)
            }
            context.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}