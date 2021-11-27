package com.veyndan.vamp.number

object Int3 : IntInterval, Int0To3, Int1To3, Int2To3 {

    override val data: Int get() = 3

    override operator fun plus(other: Int0): Int3 = Int3
}
