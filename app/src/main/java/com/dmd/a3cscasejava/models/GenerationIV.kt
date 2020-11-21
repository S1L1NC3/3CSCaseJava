package com.dmd.a3cscasejava.models
import Platinum
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenerationIV (

	@SerializedName("diamond-pearl") val diamondpearl : DiamondPearl,
	@SerializedName("heartgold-soulsilver") val heartgoldsoulsilver : HeartgoldSoulsilver,
	@SerializedName("platinum") val platinum : Platinum
) : Serializable