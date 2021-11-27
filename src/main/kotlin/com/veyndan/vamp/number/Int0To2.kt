package com.veyndan.vamp.number

sealed interface Int0To2 : IntInterval, Int0To3 {

    operator fun plus(other: Int1): Int1To3

    operator fun plus(other: Int0To1): Int0To3
}

@JvmInline
value class Int0To2Impl(override val data: Int) : Int0To2 {

    init {
        require(data in 0..2) { "$data is not within 0..2" }
    }

    override fun plus(other: Int1): Int1To3 = Int1To3Impl(this.data.plus(other.data))

    override fun plus(other: Int0To1): Int0To3 = Int0To3Impl(this.data.plus(other.data))

    override operator fun plus(other: Int0): Int0To2 = Int0To2Impl(this.data.plus(other.data))
}
