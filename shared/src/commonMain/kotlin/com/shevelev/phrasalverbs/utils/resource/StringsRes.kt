package com.shevelev.phrasalverbs.utils.resource

import dev.icerock.moko.resources.StringResource

internal expect fun StringResource.toLocString(): String

internal expect fun StringResource.toLocString(vararg args: Any): String
