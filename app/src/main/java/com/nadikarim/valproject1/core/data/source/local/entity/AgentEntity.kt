package com.nadikarim.valproject1.core.data.source.local.entity

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "agent")
data class AgentEntity(
    var assetPath: String?=null,
    var background: String?=null,
    var bustPortrait: String?=null,
    var description: String?=null,
    var developerName: String?=null,
    var displayIcon: String?=null,
    var displayIconSmall: String?=null,
    var displayName: String?=null,
    var fullPortrait: String?=null,
    var fullPortraitV2: String?=null,
    var isPlayableCharacter: Boolean,
    @PrimaryKey
    var uuid: String,
    var isFavorite: Boolean = false
) : Parcelable
