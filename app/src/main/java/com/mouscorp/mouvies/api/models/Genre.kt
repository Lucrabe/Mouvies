package com.mouscorp.mouvies.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Genre (
    @SerializedName("id") @Expose val id : Int,
    @SerializedName("name") @Expose val name : String
){

}