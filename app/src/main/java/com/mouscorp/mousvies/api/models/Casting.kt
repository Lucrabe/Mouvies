package com.mouscorp.mousvies.api.models

import com.google.gson.annotations.SerializedName

class Casting (
    @SerializedName("known_for_department") var known_for_department : String,
    @SerializedName("name") var name : String
) {
}