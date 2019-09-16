package com.emsib.mvvmdemoapp.util

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any> Any.checkItemsAre() =
    if (this is List<*>) {
        val list = this
        if (list.all { it is T })
            this as List<T>
        else null
    } else null

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any> List<*>.checkItemsAre() =
    if (all { it is T })
        this as List<T>
    else null
