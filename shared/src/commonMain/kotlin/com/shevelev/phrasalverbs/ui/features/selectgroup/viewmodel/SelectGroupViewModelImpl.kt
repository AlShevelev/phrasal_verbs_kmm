package com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.ui.resources.MR
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class SelectGroupViewModelImpl(
    private val navigation: NavigationGraph,
    private val cardsRepository: CardsRepository,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), SelectGroupViewModel {

    private var isLearnMode: Boolean = false

    override fun init(isAddNewButtonVisible: Boolean) {
        isLearnMode = !isAddNewButtonVisible

        viewModelScope.launch {
            try {
                val allGroups = cardsRepository
                    .getAllGroups()
                    .sortedBy { it.name }

                val contentItems = mutableListOf<SelectGroupItem>()

                if (isAddNewButtonVisible) {
                    contentItems.add(SelectGroupItem.NewGroup)
                }

                contentItems.addAll(
                    allGroups.map {
                        SelectGroupItem.Group(
                            id = it.id,
                            name = it.name,
                        )
                    },
                )

                _state.emit(
                    SelectGroupState.Content(items = contentItems),
                )
            } catch (ex: Exception) {
                Logger.e(ex)
                showPopup(MR.strings.general_error.toLocString())
            }
        }
    }

    private val _state = MutableStateFlow<SelectGroupState>(SelectGroupState.Loading)
    override val state: StateFlow<SelectGroupState>
        get() = _state.asStateFlow()

    override fun onBackClick() = navigation.navigateToMainMenu()

    override fun onNewGroupClick() = navigation.navigateToEditGroups(null)

    override fun onGroupClick(groupId: Long) =
        if (isLearnMode) {
            navigation.navigateToWatchAllCards(groupId)
        } else {
            navigation.navigateToEditGroups(groupId)
        }
}
