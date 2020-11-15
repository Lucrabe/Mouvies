package com.mouscorp.mouvies.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mouvies.R
import kotlinx.android.synthetic.main.activity_main.*

class MovieViewHolder(
    itemView: View,
    var movieImage : ImageView = itemView.findViewById(R.id.fragment_movie_image),
    var movieTitle: TextView = itemView.findViewById(R.id.fragment_movie_title),
    var movieNote: TextView = itemView.findViewById(R.id.fragment_movie_note)
) : RecyclerView.ViewHolder (itemView){

}