package com.mouscorp.mousvies.api.models

import com.google.gson.annotations.SerializedName

// On peut utiliser les annotations comme ci-dessous ou alors les data class
class MovieDetails (
    @SerializedName("id") var id : Int,
    @SerializedName("title") var title : String,
    @SerializedName("original_title") var originalTitle : String,
    @SerializedName("budget") var budget : Int,
    @SerializedName("original_language") var original_language : String,
    @SerializedName("poster_path") var poster_path : String,
    @SerializedName("popularity") var popularity : Number,
    @SerializedName("overview") var overview : String?,
    @SerializedName("vote_average") var vote_average : Number,
    @SerializedName("vote_count") var vote_count : Int,
    @SerializedName("status") var status : String,
    @SerializedName("spoken_languages") var spoken_languages : List<SpokenLanguage>,
    @SerializedName("revenue") var revenue : Int,
    @SerializedName("genres") var genres : List<Genre>,
    @SerializedName("release_date") var release_date : String
){

}