package com.nadikarim.valproject1.core.di

import com.nadikarim.valproject1.core.data.AgentRepository
import com.nadikarim.valproject1.core.domain.repository.IAgentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(agentRepository: AgentRepository): IAgentRepository
}