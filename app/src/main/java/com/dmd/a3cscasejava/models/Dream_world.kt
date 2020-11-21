package com.dmd.a3cscasejava.models
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DreamWorld (

	@SerializedName("front_default") val front_default : String,
	@SerializedName("front_female") val front_female : String
) : Serializable