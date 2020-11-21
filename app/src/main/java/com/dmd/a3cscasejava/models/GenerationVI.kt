package com.dmd.a3cscasejava.models
import OmegarubyAlphasapphire
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenerationVI (

	@SerializedName("omegaruby-alphasapphire") val omegarubyalphasapphire : OmegarubyAlphasapphire,
	@SerializedName("x-y") val xy : XY
) : Serializable