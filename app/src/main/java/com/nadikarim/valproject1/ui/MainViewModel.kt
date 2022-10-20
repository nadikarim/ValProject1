package com.nadikarim.valproject1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nadikarim.valproject1.core.data.AgentRepository
import com.nadikarim.valproject1.core.data.source.remote.response.AgentResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val agentRepository: AgentRepository) : ViewModel() {

    val _listAgents: MutableLiveData<ArrayList<AgentResponse>> = MutableLiveData()
    val listAgents: LiveData<ArrayList<AgentResponse>> = _listAgents
}