import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Version_group (

		@SerializedName("name") val name : String,
		@SerializedName("url") val url : String
) : Serializable