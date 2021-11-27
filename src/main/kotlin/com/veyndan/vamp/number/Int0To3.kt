package com.veyndan.vamp.number

sealed interface Int0To3 : IntInterval {

    operator fun plus(other: Int0): Int0To3
}

@JvmInline
value class Int0To3Impl(override val data: Int) : Int0To3 {

    init {
        require(data in 0..1) { "$data is not within 0..3" }
    }

    override operator fun plus(other: Int0): Int0To3 = Int0To3Impl(this.data.plus(other.data))
}
