package com.dmd.a3cscasejava.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenerationIII (

	@SerializedName("emerald") val emerald : Emerald,
	@SerializedName("firered-leafgreen") val fireredleafgreen : FireredLeafgreen,
	@SerializedName("ruby-sapphire") val rubysapphire : RubySapphire
) : Serializable