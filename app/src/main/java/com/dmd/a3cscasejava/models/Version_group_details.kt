import com.dmd.a3cscasejava.models.MoveLearnMethod
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VersionGroupDetails (

		@SerializedName("level_learned_at") val level_learned_at : Int,
		@SerializedName("move_learn_method") val move_learn_method : MoveLearnMethod,
		@SerializedName("version_group") val version_group : VersionGroup
) : Serializable