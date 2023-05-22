package com.shevelev.phrasalverbs.utils.resource

import dev.icerock.moko.resources.StringResource

expect fun StringResource.toLocString(): String

expect fun StringResource.toLocString(vararg args: Any): String
