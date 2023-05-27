package com.shevelev.phrasalverbs.core.ui.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.popup.MessagePopupData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class ViewModelBase(
    private val scopeClosable: KoinScopeClosable,
) : ViewModel {
    private val viewModelJob = SupervisorJob()

    private val _messagePopup = MutableSharedFlow<MessagePopupData>(
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
        extraBufferCapacity = 1,
    )
    override val messagePopup: SharedFlow<MessagePopupData>
        get() = _messagePopup.asSharedFlow()

    protected val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    protected fun showPopup(message: String) {
        _messagePopup.tryEmit(MessagePopupData(message))
    }

    override fun close() {
        viewModelJob.cancel()
        scopeClosable.closeScope()
    }
}
