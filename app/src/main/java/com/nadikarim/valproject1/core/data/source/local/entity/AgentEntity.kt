package com.nadikarim.valproject1.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "agent")
data class AgentEntity(
    var assetPath: String,
    var background: String,
    var bustPortrait: String,
    var description: String,
    var developerName: String,
    var displayIcon: String,
    var displayIconSmall: String,
    var displayName: String,
    var fullPortrait: String,
    var fullPortraitV2: String,
    var isPlayableCharacter: Boolean,
    @PrimaryKey
    var uuid: String,
    var isFavorite: Boolean = false
):Parcelable
