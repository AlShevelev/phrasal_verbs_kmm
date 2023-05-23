package com.shevelev.phrasalverbs.ui.features.learning.di

import com.shevelev.phrasalverbs.ui.features.learning.viewmodel.LearningViewModel
import com.shevelev.phrasalverbs.ui.features.learning.viewmodel.LearningViewModelImpl
import com.shevelev.phrasalverbs.utils.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.utils.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.utils.koin.closeKoinScope
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal object LearningKoinScope : KoinScopeDescriptor {
    override val name: StringQualifier = named("LEARNING_SCOPE")
    override val id: String = "622eb456-79fa-4922-a541-88617fa29132"
}

val LearningKoinModule = module {
    scope(LearningKoinScope.name) {
        scoped<LearningViewModel> {
            LearningViewModelImpl(
                navigation = get(),
                scopeClosable = object : KoinScopeClosable {
                    override fun closeScope() {
                        closeKoinScope(LearningKoinScope)
                    }
                },
            )
        }
    }
}
