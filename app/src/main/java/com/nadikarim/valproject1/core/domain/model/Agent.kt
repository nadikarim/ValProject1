package com.nadikarim.valproject1.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Agent(
    val assetPath: String? =null,
    val background: String? =null,
    val bustPortrait: String? =null,
    val description: String? =null,
    val developerName: String? =null,
    val displayIcon: String? =null,
    val displayIconSmall: String? =null,
    val displayName:String? =null,
    val fullPortrait: String? =null,
    val fullPortraitV2: String? =null,
    val isPlayableCharacter: Boolean,
    val uuid: String,
)
