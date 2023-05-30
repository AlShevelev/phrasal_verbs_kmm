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
        processStandardAction {
            _state.emit(
                SettingsState.Content(
                    isRussianSideDefault = keyValueStorageRepository.getIsRussianSideDefault(),
                    isInfiniteCardsList = keyValueStorageRepository.getIsInfiniteCardsList(),
                ),
            )
        }
    }

    override fun onBackClick() {
        navigation.navigateToMainMenu()
    }

    override fun updateIsRussianSideDefault(value: Boolean) {
        processStandardAction {
            keyValueStorageRepository.setIsRussianSideDefault(value)
            updateState {
                it.copy(isRussianSideDefault = value)
            }
        }
    }

    override fun updateIsIsInfiniteCardsList(value: Boolean) {
        processStandardAction {
            keyValueStorageRepository.setIsInfiniteCardsList(value)
            updateState {
                it.copy(isInfiniteCardsList = value)
            }
        }
    }

    private suspend fun updateState(action: (SettingsState.Content) -> SettingsState.Content) =
        (_state.value as? SettingsState.Content)?.let {
            _state.emit(action(it))
        }

    private fun processStandardAction(action: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                action()
            } catch (ex: Exception) {
                Logger.e(ex)
                showPopup(MR.strings.general_error.toLocString())
            }
        }
    }
}
