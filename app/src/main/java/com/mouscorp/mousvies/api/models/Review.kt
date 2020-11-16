package com.mouscorp.mousvies.api.models

import com.google.gson.annotations.SerializedName

class Review (

    @SerializedName("results") var results : List<Author>

) {
}