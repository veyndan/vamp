package com.veyndan.vamp.number

object Int2 : IntInterval, Int0To2, Int0To3, Int1To2, Int1To3, Int2To3 {

    override val data: Int get() = 2

    override operator fun plus(other: Int0): Int2 = Int2

    override fun plus(other: Int0To1): Int2To3 = Int2To3Impl(this.data.plus(other.data))

    override fun plus(other: Int1): Int3 = Int3
}
