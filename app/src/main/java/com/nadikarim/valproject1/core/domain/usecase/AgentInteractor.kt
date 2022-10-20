package com.nadikarim.valproject1.core.domain.usecase

import com.nadikarim.valproject1.core.domain.model.Agent
import com.nadikarim.valproject1.core.domain.repository.IAgentRepository
import javax.inject.Inject

class AgentInteractor @Inject constructor(private val agentRepository: IAgentRepository): AgentUseCase {
    override fun getAllAgent() = agentRepository.getAllAgent()
    override fun getFavoriteAgent() = agentRepository.getFavoriteAgent()
    override fun setFavoriteAgent(agent: Agent, state: Boolean) = agentRepository.setFavoriteAgent(agent, state)
}