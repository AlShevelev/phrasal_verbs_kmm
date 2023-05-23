package com.shevelev.phrasalverbs.utils.resource

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc

internal actual fun StringResource.toLocString(): String {
    return StringDesc.Resource(this).localized()
}

internal actual fun StringResource.toLocString(vararg args: Any): String {
    return StringDesc.ResourceFormatted(this, *args).localized()
}
