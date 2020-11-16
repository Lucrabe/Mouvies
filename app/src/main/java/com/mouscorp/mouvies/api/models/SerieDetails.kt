package com.mouscorp.mouvies.api.models

import com.google.gson.annotations.SerializedName

class SerieDetails(
    @SerializedName("name") var name : String,
    @SerializedName("genres") var genres : List<Genre>,
    @SerializedName("in_production") var in_production : Boolean,
    @SerializedName("original_language") var original_language : String,
    @SerializedName("original_name") var original_name : String,
    @SerializedName("poster_path") var poster_path : String,
    @SerializedName("popularity") var popularity : Number,
    @SerializedName("overview") var overview : String?,
    @SerializedName("vote_average") var vote_average : Number,
    @SerializedName("vote_count") var vote_count : Int,
    @SerializedName("status") var status : String,
    @SerializedName("languages") var languages : List<String>,
    @SerializedName("release_date") var release_date : String,
    @SerializedName("production_companies") var production_companies : Int,
    @SerializedName("seasons") var seasons : List<Season>,
    @SerializedName("first_air_date") var first_air_date : String,
    @SerializedName("last_air_date") var last_air_date : String,
    @SerializedName("number_of_episodes") var number_of_episodes : Int,
    @SerializedName("number_of_seasons") var number_of_seasons : Int

    )
{

}