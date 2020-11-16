package com.mouscorp.mousvies.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mousvies.R
import kotlinx.android.synthetic.main.description.view.*

class MovieDetailsViewHolder (
    itemView: View,
    var movieImage : ImageView = itemView.findViewById(R.id.fragment_movie_details_image),
    var movieTitle : TextView = itemView.findViewById(R.id.movie_details_title),
    var movieNote : TextView = itemView.findViewById(R.id.movie_details_note),
    var movieDescription : TextView = itemView.findViewById(R.id.movie_details_description)

) : RecyclerView.ViewHolder(itemView){

}