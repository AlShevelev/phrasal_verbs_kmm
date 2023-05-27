package com.shevelev.phrasalverbs.core.ui.viewmodel

import com.shevelev.phrasalverbs.core.ui.popup.MessagePopupData
import kotlinx.coroutines.flow.SharedFlow

interface ViewModel {
    val messagePopup: SharedFlow<MessagePopupData>

    fun close()
}
