import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Yellow (

		@SerializedName("back_default") val back_default : String,
		@SerializedName("back_gray") val back_gray : String,
		@SerializedName("front_default") val front_default : String,
		@SerializedName("front_gray") val front_gray : String
) : Serializable