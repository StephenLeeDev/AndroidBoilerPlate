package com.stephen.androidbolierplate.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.domain.usecases.GetBoilerPlateUseCase
import com.stephen.androidbolierplate.domain.usecases.GetPagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 * Written by StephenLeeDev on 2022/07/25.
 */

@HiltViewModel
class BoilerPlateViewModel @Inject constructor(
    private val getBoilerPlateUseCase: GetBoilerPlateUseCase,
//    private val getPagingUseCase: GetPagingUseCase
) : ViewModel() {

    private val _boilerPlateState = MutableLiveData<BoilerPlateState>(BoilerPlateState.Progress)
    val boilerPlateState = _boilerPlateState as LiveData<BoilerPlateState>

    fun getBoilerPlate() {
        viewModelScope.launch {
            getBoilerPlateUseCase.execute()
                .catch {
                    _boilerPlateState.value = BoilerPlateState.Fail
                }
                .collect {
                    _boilerPlateState.value = BoilerPlateState.Success(it)
                }
        }
    }

//    fun getPagingBoilerPlate() {
//        viewModelScope.launch {
//            getPagingUseCase.execute().cachedIn(viewModelScope)
//                .catch {  }
//                .collectLatest {
//
//                }
//        }
//    }

}

