package com.veyndan.vamp.number

sealed interface Int1To3 : IntInterval, Int0To3

@JvmInline
value class Int1To3Impl(override val data: Int) : Int1To3 {

    init {
        require(data in 0..1) { "$data is not within 1..3" }
    }

    override operator fun plus(other: Int0): Int1To3 = Int1To3Impl(this.data.plus(other.data))
}
