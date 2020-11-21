import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Icons (

	@SerializedName("front_default") val front_default : String,
	@SerializedName("front_female") val front_female : String
) : Serializable