package com.veyndan.vamp.number

sealed interface Int1To2 : IntInterval, Int0To2, Int0To3, Int1To3 {

    override operator fun plus(other: Int0): Int1To2
}

@JvmInline
value class Int1To2Impl(override val data: Int) : Int1To2 {

    init {
        require(data in 1..2) { "$data is not within 1..2" }
    }

    override operator fun plus(other: Int0): Int1To2 = Int1To2Impl(this.data.plus(other.data))

    override fun plus(other: Int1): Int2To3 = Int2To3Impl(this.data.plus(other.data))

    override fun plus(other: Int0To1): Int1To3 = Int1To3Impl(this.data.plus(other.data))
}
