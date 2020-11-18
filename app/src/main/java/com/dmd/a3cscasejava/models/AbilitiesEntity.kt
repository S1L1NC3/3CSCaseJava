package com.dmd.a3cscasejava.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AbilitiesEntity(
        @Expose
        @SerializedName("ability")
        var ability: AbilityEntity,
        @Expose
        @SerializedName("is_hidden")
        var ısHidden: Boolean,
        @Expose
        @SerializedName("slot")
        var slot: Int)