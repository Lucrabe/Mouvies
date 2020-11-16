package com.mouscorp.mousvies.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mousvies.R
import com.mouscorp.mousvies.api.adapter.MovieSearchRecyclerViewAdapter
import com.mouscorp.mousvies.api.models.Movie

class MovieSearchViewHolder (
    itemView: View,
    var movieTitle : TextView = itemView.findViewById(R.id.search_title),
    var movieImage: ImageView = itemView.findViewById(R.id.search_image_view),
    var movieId: TextView = itemView.findViewById(R.id.search_id),
    var movieAverage: TextView = itemView.findViewById(R.id.search_average)
) : RecyclerView.ViewHolder(itemView) {


}