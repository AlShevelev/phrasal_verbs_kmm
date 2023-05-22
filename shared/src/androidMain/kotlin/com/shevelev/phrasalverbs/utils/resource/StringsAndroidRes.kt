package com.shevelev.phrasalverbs.utils.resource

import android.content.Context
import com.shevelev.phrasalverbs.utils.koin.getKoin
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc

actual fun StringResource.toLocString(): String {
    val context = getKoin<Context>()
    return StringDesc.Resource(this).toString(context)
}

actual fun StringResource.toLocString(vararg args: Any): String {
    val context = getKoin<Context>()
    return StringDesc.ResourceFormatted(this, *args).toString(context)
}