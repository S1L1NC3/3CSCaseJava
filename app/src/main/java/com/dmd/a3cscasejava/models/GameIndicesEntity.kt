package com.dmd.a3cscasejava.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GameIndicesEntity(
        @Expose
        @SerializedName("game_index")
        var gameIndex: Int,
        @Expose
        @SerializedName("version")
        var version: VersionEntity)