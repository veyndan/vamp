package com.veyndan.vamp.number

object Int0 : IntInterval, Int0To1, Int0To2, Int0To3 {

    override val data: Int get() = 0

    override operator fun plus(other: Int0): Int0 = other

    override operator fun plus(other: Int0To1): Int0To1 = other

    override operator fun plus(other: Int0To2): Int0To2 = other

    operator fun plus(other: Int0To3): Int0To3 = other

    override operator fun plus(other: Int1): Int1 = other

    override operator fun plus(other: Int1To2): Int1To2 = other

    operator fun plus(other: Int1To3): Int1To3 = other

    override operator fun plus(other: Int2): Int2 = other

    operator fun plus(other: Int2To3): Int2To3 = other

    operator fun plus(other: Int3): Int3 = other
}
