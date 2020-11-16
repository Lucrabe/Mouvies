package com.mouscorp.mousvies.api.models

import com.google.gson.annotations.SerializedName

class Credits (
    @SerializedName("cast") var cast : List<Casting>
) {
}