package com.nadikarim.valproject1.core.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import com.nadikarim.valproject1.core.data.source.remote.response.AgentResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    @SuppressLint("CheckResult")
    suspend fun getAllAgents(): Flow<ApiResponse<List<AgentResponse>>> {

        //get data from  mremote api
        return flow {
            try {
                val response = apiService.getAllAgents()
                val dataArray = response.agents
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.agents))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                val response = apiService.getAllAgents()
                Log.e("RemoteDataSource", response.toString())
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    }

}