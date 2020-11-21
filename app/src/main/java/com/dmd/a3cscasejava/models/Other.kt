import com.dmd.a3cscasejava.models.Dream_world
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Other (

		@SerializedName("dream_world") val dream_world : Dream_world,
		@SerializedName("official-artwork") val officialartwork : Officialartwork
) : Serializable