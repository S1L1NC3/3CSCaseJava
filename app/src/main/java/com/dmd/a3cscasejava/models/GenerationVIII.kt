package com.dmd.a3cscasejava.models
import Icons
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenerationVIII (

	@SerializedName("icons") val icons : Icons
) : Serializable