package com.veyndan.vamp.number

sealed interface Int2To3 : IntInterval, Int0To3, Int1To3

@JvmInline
value class Int2To3Impl(override val data: Int) : Int2To3 {

    init {
        require(data in 0..1) { "$data is not within 2..3" }
    }

    override operator fun plus(other: Int0): Int2To3 = Int2To3Impl(this.data.plus(other.data))
}
