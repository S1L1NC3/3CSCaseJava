package com.dmd.a3cscasejava.models

import Silver
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenerationII (

	@SerializedName("crystal") val crystal : Crystal,
	@SerializedName("gold") val gold : Gold,
	@SerializedName("silver") val silver : Silver
) : Serializable