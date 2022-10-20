package com.nadikarim.valproject1.core.data.source.local.db

import androidx.room.*
import com.nadikarim.valproject1.core.data.source.local.entity.AgentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentDao {
    @Query("SELECT * FROM agent")
    fun getAllAgent(): Flow<List<AgentEntity>>

    @Query("SELECT * FROM agent where isFavorite = 1")
    fun getFavoriteAgent(): Flow<List<AgentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAgent(agent: List<AgentEntity>)

    @Update
    fun updateFavoriteAgent(agent: AgentEntity)
}