import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Move_learn_method (

		@SerializedName("name") val name : String,
		@SerializedName("url") val url : String
) : Serializable