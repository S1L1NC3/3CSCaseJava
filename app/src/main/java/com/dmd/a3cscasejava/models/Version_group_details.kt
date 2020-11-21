import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Version_group_details (

		@SerializedName("level_learned_at") val level_learned_at : Int,
		@SerializedName("move_learn_method") val move_learn_method : Move_learn_method,
		@SerializedName("version_group") val version_group : Version_group
) : Serializable