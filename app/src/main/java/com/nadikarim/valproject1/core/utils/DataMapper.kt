package com.nadikarim.valproject1.core.utils

import com.nadikarim.valproject1.core.data.source.local.entity.AgentEntity
import com.nadikarim.valproject1.core.data.source.remote.response.AgentResponse
import com.nadikarim.valproject1.core.domain.model.Agent

object DataMapper {

    fun mapEntitiesToDomain(input: List<AgentEntity>): List<Agent> =
        input.map {
            Agent(
                assetPath = it.assetPath,
                background = it.background,
                bustPortrait = it.bustPortrait,
                description = it.description,
                developerName = it.developerName,
                displayIcon = it.displayIcon,
                displayIconSmall = it.displayIconSmall,
                displayName = it.displayName,
                fullPortrait = it.fullPortrait,
                fullPortraitV2 = it.fullPortraitV2,
                isPlayableCharacter = it.isPlayableCharacter,
                uuid = it.uuid
            )
        }


    fun mapDomainToEntity(input: Agent) = AgentEntity(
        assetPath = input.assetPath,
        background = input.background,
        bustPortrait = input.bustPortrait,
        description = input.description,
        developerName = input.developerName,
        displayIcon = input.displayIcon,
        displayIconSmall = input.displayIconSmall,
        displayName = input.displayName,
        fullPortrait = input.fullPortrait,
        fullPortraitV2 = input.fullPortraitV2,
        isPlayableCharacter = input.isPlayableCharacter,
        uuid = input.uuid
    )


    fun mapResponsesToEntities(input: List<AgentResponse>): List<AgentEntity> {
        val agentList = ArrayList<AgentEntity>()
        input.map {
            val agentEntity = AgentEntity(
                assetPath = it.assetPath,
                background = it.background,
                bustPortrait = it.bustPortrait,
                description = it.description,
                developerName = it.developerName,
                displayIcon = it.displayIcon,
                displayIconSmall = it.displayIconSmall,
                displayName = it.displayName,
                fullPortrait = it.fullPortrait,
                fullPortraitV2 = it.fullPortraitV2,
                isPlayableCharacter = it.isPlayableCharacter,
                uuid = it.uuid ,
                isFavorite = false
            )
            agentList.add(agentEntity)
        }
        return agentList
    }
}