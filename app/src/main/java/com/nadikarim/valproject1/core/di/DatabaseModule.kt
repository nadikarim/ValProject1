package com.nadikarim.valproject1.core.di

import android.content.Context
import androidx.room.Room
import com.nadikarim.valproject1.core.data.source.local.db.AgentDao
import com.nadikarim.valproject1.core.data.source.local.db.AgentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AgentDatabase = Room.databaseBuilder(
        context,
        AgentDatabase::class.java, "Agent.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideAgentDao(database: AgentDatabase): AgentDao = database.agentDao()
}