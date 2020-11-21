package com.dmd.a3cscasejava.models
import Version
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Game_indices (

	@SerializedName("game_index") val game_index : Int,
	@SerializedName("version") val version : Version
) : Serializable