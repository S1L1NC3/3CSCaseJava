import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Officialartwork (

	@SerializedName("front_default") val front_default : String
) : Serializable