import com.dmd.a3cscasejava.models.Move
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Moves (

		@SerializedName("move") val move : Move,
		@SerializedName("version_group_details") val version_group_details : List<Version_group_details>
) : Serializable