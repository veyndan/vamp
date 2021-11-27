package com.veyndan.vamp.number

object Int1 : IntInterval, Int0To1, Int0To2, Int0To3, Int1To2, Int1To3 {

    override val data: Int get() = 1

    override operator fun plus(other: Int0): Int1 = Int1

    override operator fun plus(other: Int0To1): Int1To2 = Int1To2Impl(this.data.plus(other.data))

    override fun plus(other: Int0To2): Int1To3 = Int1To3Impl(this.data.plus(other.data))

    override fun plus(other: Int1To2): Int2To3 = Int2To3Impl(this.data.plus(other.data))

    override fun plus(other: Int2): Int3 = Int3

    override operator fun plus(other: Int1): Int2 = Int2
}
