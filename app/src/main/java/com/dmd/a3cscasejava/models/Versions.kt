package com.dmd.a3cscasejava.models
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Versions (

	@SerializedName("generation-i") val generationi : GenerationI,
	@SerializedName("generation-ii") val generationii : GenerationII,
	@SerializedName("generation-iii") val generationiii : GenerationIII,
	@SerializedName("generation-iv") val generationiv : GenerationIV,
	@SerializedName("generation-v") val generationv : GenerationV,
	@SerializedName("generation-vi") val generationvi : GenerationVI,
	@SerializedName("generation-vii") val generationvii : GenerationVII,
	@SerializedName("generation-viii") val generationviii : GenerationVIII
) : Serializable