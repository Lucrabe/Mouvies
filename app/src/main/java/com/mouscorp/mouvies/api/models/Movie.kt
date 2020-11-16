package com.mouscorp.mouvies.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Annotation similaire a Symfony ou dans .Net
class Movie (
    @SerializedName("id") @Expose var id: String,
    @SerializedName("title") @Expose var title: String,
    @SerializedName("poster_path") @Expose var posterPath: String,
    @SerializedName("backdrop_path") @Expose var backdropPath: String,
    @SerializedName("vote_average") @Expose var vote_average: Number
){

}