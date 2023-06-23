package com.shevelev.phrasalverbs.core

/**
 * A sql-like inner join between [this] and [right] by condition [by]
 */
inline fun <TCL, TCR> Iterable<TCL>.innerJoin(
    right: Iterable<TCR>,
    by: (TCL, TCR) -> Boolean
): List<Pair<TCL, TCR>> {
    val result = mutableListOf<Pair<TCL, TCR>>()

    this.forEach { l ->
        right.forEach { r ->
            if (by(l, r)) {
                result.add(Pair(l, r))
            }
        }
    }

    return result
}

/**
 * Exclude from the list [this] items from the list [right] by condition [by]
 */
inline fun <TCL, TCR> Iterable<TCL>.exclude(
    right: Iterable<TCR>,
    by: (TCL, TCR) -> Boolean
): List<TCL> {
    val result = mutableListOf<TCL>()

    this.forEach { l ->
        var found = false
        for (r in right) {
            if (by(l, r)) {
                found = true
                break
            }
        }

        if (!found) {
            result.add(l)
        }
    }

    return result
}
