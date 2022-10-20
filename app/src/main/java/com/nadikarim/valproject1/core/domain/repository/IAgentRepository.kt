package com.nadikarim.valproject1.core.domain.repository

import com.nadikarim.valproject1.core.data.Resource
import com.nadikarim.valproject1.core.domain.model.Agent
import kotlinx.coroutines.flow.Flow

interface IAgentRepository {
    fun getAllAgent(): Flow<Resource<List<Agent>>>
    fun getFavoriteAgent(): Flow<List<Agent>>
    fun setFavoriteAgent(agent: Agent, state: Boolean)
}