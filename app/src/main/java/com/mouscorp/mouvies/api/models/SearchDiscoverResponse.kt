package com.mouscorp.mouvies.api.models

import androidx.annotation.NonNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchDiscoverResponse (
    @SerializedName("page") @Expose var page : Int,
    @SerializedName("total_pages") @Expose var totalPages : Int,
    @SerializedName("total_results") var totalResults : Int,
    @SerializedName("results") @Expose var results : ArrayList<Movie>
){
    @NonNull
    @Override
    override fun toString() : String{
        return results.toString()
    }
}