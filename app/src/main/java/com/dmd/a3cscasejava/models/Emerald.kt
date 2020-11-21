package com.dmd.a3cscasejava.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Emerald (

	@SerializedName("front_default") val front_default : String,
	@SerializedName("front_shiny") val front_shiny : String
) : Serializable