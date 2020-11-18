package com.dmd.a3cscasejava.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VersionEntity(
        @Expose
        @SerializedName("name")
        val name: String,
        @Expose
        @SerializedName("url")
        val url: String)