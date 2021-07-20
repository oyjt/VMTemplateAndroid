package com.vmloft.develop.app.template.ui.settings

import androidx.lifecycle.viewModelScope
import com.vmloft.develop.app.template.request.repository.CommonRepository

import com.vmloft.develop.library.common.base.BViewModel
import com.vmloft.develop.library.common.request.RResult

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Create by lzan13 on 2021/07/11 17:28
 * 描述：设置相关 ViewModel
 */
class SettingsViewModel(private val repo: CommonRepository) : BViewModel() {

    /**
     * 加载隐私政策
     */
    fun getPrivacyPolicy() {
        viewModelScope.launch(Dispatchers.Main) {
            emitUIState(true)
            val result = withContext(Dispatchers.IO) {
                repo.getPrivacyPolicy()
            }

            if (result is RResult.Success) {
                emitUIState(data = result.data, type = "privacyPolicy")
                return@launch
            } else if (result is RResult.Error) {
                emitUIState(isSuccess = false, code = result.code, error = result.error)
            }
        }
    }

    /**
     * 加载用户协议
     */
    fun getUserAgreement() {
        viewModelScope.launch(Dispatchers.Main) {
            emitUIState(true)
            val result = withContext(Dispatchers.IO) {
                repo.getUserAgreement()
            }
            if (result is RResult.Success) {
                emitUIState(data = result.data, type = "userAgreement")
                return@launch
            } else if (result is RResult.Error) {
                emitUIState(isSuccess = false, code = result.code, error = result.error)
            }
        }
    }

}