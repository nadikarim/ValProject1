package com.nadikarim.valproject1.core.data.source.remote

import com.nadikarim.valproject1.core.data.source.remote.response.ListAgentResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("agents")
    suspend fun getAllAgents(
        @Query("isPlayableCharacter")playableAgent: Boolean = true
    ): ListAgentResponse
}