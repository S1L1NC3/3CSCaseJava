import com.dmd.a3cscasejava.models.DreamWorld
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Other (

		@SerializedName("dream_world") val dream_world : DreamWorld,
		@SerializedName("official-artwork") val officialartwork : Officialartwork
) : Serializable