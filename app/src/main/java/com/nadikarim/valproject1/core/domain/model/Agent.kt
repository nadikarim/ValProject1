package com.nadikarim.valproject1.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agent(
    val assetPath: String,
    val background: String,
    val bustPortrait: String,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val displayIconSmall: String,
    val displayName: String,
    val fullPortrait: String,
    val fullPortraitV2: String,
    val isPlayableCharacter: Boolean,
    val uuid: String,
): Parcelable
