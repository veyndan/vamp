package com.veyndan.vamp.number

sealed interface IntInterval {

    val data: Int
}

// TODO Below I'm just trying stuff out

interface IntInterval2<A, B> {

    val data: Int

    operator fun <C, D, E> plus(other: C): IntInterval2<D, E>
}

class Int0To3Temp(override val data: Int) : IntInterval2<Int0, Int3> {

    override fun <C, D, E> plus(other: C): IntInterval2<D, E> {
        return when (other) {
            is Int0 -> Int0To3Temp(data)
            is Int1 -> TODO()
            is Int0To1 -> TODO()
            else -> error("Unknown")
        }
    }
}
