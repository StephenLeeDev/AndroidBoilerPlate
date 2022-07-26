package com.stephen.androidbolierplate.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.data.usecases.GetBoilerPlateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

@HiltViewModel
class BoilerPlateViewModel @Inject constructor(
    private val getBoilerPlateUseCase: GetBoilerPlateUseCase
) : ViewModel() {

    private val _getBoilerPlateResponse = MutableLiveData<List<BoilerPlateModel>>()
    val getBoilerPlateResponse = _getBoilerPlateResponse as LiveData<List<BoilerPlateModel>>

    // 금일 근무시간 정보
    fun getBoilerPlate() {
        viewModelScope.launch {
            getBoilerPlateUseCase.execute()
                .catch { }
                .collect {
                    _getBoilerPlateResponse.value = it
                }
        }
    }

}