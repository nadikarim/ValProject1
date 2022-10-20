package com.nadikarim.valproject1.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.nadikarim.valproject1.core.domain.usecase.AgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(agentUseCase: AgentUseCase) : ViewModel(){

    val agent = agentUseCase.getAllAgent().asLiveData()
}