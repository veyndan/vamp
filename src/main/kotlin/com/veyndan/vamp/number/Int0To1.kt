package com.veyndan.vamp.number

sealed interface Int0To1 : IntInterval, Int0To2, Int0To3 {

    operator fun plus(other: Int0To2): Int0To3

    operator fun plus(other: Int1To2): Int1To3

    operator fun plus(other: Int2): Int2To3
}

@JvmInline
value class Int0To1Impl(override val data: Int) : Int0To1 {

    init {
        require(data in 0..1) { "$data is not within 0..1" }
    }

    override operator fun plus(other: Int0): Int0To1 = Int0To1Impl(this.data.plus(other.data))

    override operator fun plus(other: Int0To1): Int0To2 = Int0To2Impl(this.data.plus(other.data))

    override operator fun plus(other: Int1): Int1To2 = Int1To2Impl(this.data.plus(other.data))

    override fun plus(other: Int0To2): Int0To3 = Int0To3Impl(this.data.plus(other.data))

    override fun plus(other: Int1To2): Int1To3 = Int1To3Impl(this.data.plus(other.data))

    override fun plus(other: Int2): Int2To3 = Int2To3Impl(this.data.plus(other.data))
}
