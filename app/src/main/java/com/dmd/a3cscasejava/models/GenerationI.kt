package com.dmd.a3cscasejava.models

import Yellow
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenerationI (

	@SerializedName("red-blue") val redblue : RedBlue,
	@SerializedName("yellow") val yellow : Yellow
) : Serializable