package com.nadikarim.valproject1.core.data.source.remote.response

data class ListAgentResponse(
    val agents: List<AgentResponse>,
    val status: Int
)