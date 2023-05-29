package com.shevelev.phrasalverbs.ui.features.settings.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageRepository
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class SettingsViewModelImpl(
    private val navigation: NavigationGraph,
    private val keyValueStorageRepository: KeyValueStorageRepository,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), SettingsViewModel {

    private val _state = MutableStateFlow<SettingsState>(SettingsState.Loading)
    override val state: StateFlow<SettingsState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _state.emit(
                    SettingsState.Content(
                        isRussianSideDefault = keyValueStorageRepository.getIsRussianSideDefault(),
                    ),
                )
            } catch (ex: Exception) {
                Logger.e(ex)
                showPopup(MR.strings.general_error.toLocString())
            }
        }
    }

    override fun onBackClick() {
        navigation.navigateToMainMenu()
    }

    override fun updateIsRussianSideDefault(value: Boolean) {
        viewModelScope.launch {
            try {
                keyValueStorageRepository.setIsRussianSideDefault(value)

                _state.emit(
                    SettingsState.Content(
                        isRussianSideDefault = value,
                    ),
                )
            } catch (ex: Exception) {
                Logger.e(ex)
                showPopup(MR.strings.general_error.toLocString())
            }
        }
    }
}
