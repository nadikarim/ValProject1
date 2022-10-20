package com.nadikarim.valproject1.di

import com.nadikarim.valproject1.core.domain.usecase.AgentInteractor
import com.nadikarim.valproject1.core.domain.usecase.AgentUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideAgentUseCase(agentInteractor: AgentInteractor): AgentUseCase

}