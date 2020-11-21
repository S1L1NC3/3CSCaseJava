package com.dmd.a3cscasejava.models
import com.google.gson.annotations.SerializedName
import com.dmd.a3cscasejava.models.BlackWhite
import java.io.Serializable


data class GenerationV (

	@SerializedName("black-white") val blackwhite : BlackWhite
) : Serializable