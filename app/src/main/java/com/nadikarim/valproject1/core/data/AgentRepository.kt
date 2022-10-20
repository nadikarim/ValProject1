package com.nadikarim.valproject1.core.data

import com.nadikarim.valproject1.core.data.source.local.LocalDataSource
import com.nadikarim.valproject1.core.data.source.remote.ApiResponse
import com.nadikarim.valproject1.core.data.source.remote.RemoteDataSource
import com.nadikarim.valproject1.core.data.source.remote.response.AgentResponse
import com.nadikarim.valproject1.core.domain.model.Agent
import com.nadikarim.valproject1.core.domain.repository.IAgentRepository
import com.nadikarim.valproject1.core.utils.AppExecutors
import com.nadikarim.valproject1.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AgentRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IAgentRepository {
    override fun getAllAgent(): Flow<Resource<List<Agent>>> =
        object : NetworkBoundResource<List<Agent>, List<AgentResponse>>() {
            override fun loadFromDB(): Flow<List<Agent>> {
                return localDataSource.getAllAgent().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Agent>?): Boolean =
                data == null || data.isEmpty()


            override suspend fun createCall(): Flow<ApiResponse<List<AgentResponse>>> =
                remoteDataSource.getAllAgents()


            override suspend fun saveCallResult(data: List<AgentResponse>) {
                val agentList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertAgent(agentList)
            }

        }.asFlow()

    override fun getFavoriteAgent(): Flow<List<Agent>> {
        return localDataSource.getFavoriteAgent().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteAgent(agent: Agent, state: Boolean) {
        val agentEntity = DataMapper.mapDomainToEntity(agent)
        appExecutors.diskIO().execute { localDataSource.setFavoriteAgent(agentEntity, state) }
    }

}