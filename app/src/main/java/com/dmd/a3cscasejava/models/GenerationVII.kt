package com.dmd.a3cscasejava.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenerationVII (

	@SerializedName("icons") val icons : Icons,
	@SerializedName("ultra-sun-ultra-moon") val ultrasunultramoon : UltraSunUltraMoon
) : Serializable