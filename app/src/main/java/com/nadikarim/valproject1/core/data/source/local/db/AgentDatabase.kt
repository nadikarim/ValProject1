package com.nadikarim.valproject1.core.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nadikarim.valproject1.core.data.source.local.entity.AgentEntity

@Database(entities = [AgentEntity::class], version = 1, exportSchema = false)
abstract class AgentDatabase : RoomDatabase() {

    abstract fun agentDao(): AgentDao
}