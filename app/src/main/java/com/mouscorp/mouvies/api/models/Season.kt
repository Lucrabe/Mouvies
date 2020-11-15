package com.mouscorp.mouvies.api.models

import com.google.gson.annotations.SerializedName

class Season(
    @SerializedName("air_date") var air_date : String,
    @SerializedName("episode_count") var episode_count : Int,
    @SerializedName("overview") var overview : String,
    @SerializedName("poster_path") var poster_path : String,
    @SerializedName("season_number") var season_number : Int
    ) {
}