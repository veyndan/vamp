package com.veyndan.vamp.number.nonnegative

/**
 * [UInt] provide no guarantee that its backing value was originally a non-negative number. For example,
 * `(-1).toUInt()` actually stores the maximum [UInt] that can be stored. Unsigned numbers are useful for algorithmic
 * optimisations, whereas [NonNegativeInt] is useful for domain driven modelling.
 *
 * The name `NaturalNumber` was not used due to the ambiguity of the allowable range including or excluding zero.
 */
@JvmInline
value class NonNegativeInt @PublishedApi internal constructor(@PublishedApi internal val data: Int) : Comparable<NonNegativeInt> {

    companion object {

        /**
         * A constant holding the minimum value an instance of [NonNegativeInt] can have.
         */
        val MIN_VALUE: NonNegativeInt = NonNegativeInt(0)

        /**
         * A constant holding the maximum value an instance of [NonNegativeInt] can have.
         */
        val MAX_VALUE: NonNegativeInt = NonNegativeInt(Int.MAX_VALUE)
    }

    init {
        require(data >= 0) { "$data is negative" }
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: NonNegativeInt): Int = this.data.compareTo(other.data)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: NonNegativeLong): Int = this.toNonNegativeLong().compareTo(other)

    /** Adds the other value to this value. */
    operator fun plus(other: NonNegativeInt): NonNegativeInt = NonNegativeInt(this.data.plus(other.data))
    /** Adds the other value to this value. */
    operator fun plus(other: NonNegativeLong): NonNegativeLong = this.toNonNegativeLong().plus(other)

    /** Subtracts the other value from this value. */
    operator fun minus(other: NonNegativeInt): Int = this.data.minus(other.data)
    /** Subtracts the other value from this value. */
    operator fun minus(other: NonNegativeLong): Long = this.toNonNegativeLong().minus(other)

    /** Multiplies this value by the other value. */
    operator fun times(other: NonNegativeInt): NonNegativeInt = NonNegativeInt(this.data.times(other.data))
    /** Multiplies this value by the other value. */
    operator fun times(other: NonNegativeLong): NonNegativeLong = this.toNonNegativeLong().times(other)

    /** Divides this value by the other value. */
    operator fun div(other: NonNegativeInt): NonNegativeInt = NonNegativeInt(this.data.div(other.data))
    /** Divides this value by the other value. */
    operator fun div(other: NonNegativeLong): NonNegativeLong = this.toNonNegativeLong().div(other)

    /** Calculates the remainder of dividing this value by the other value. */
    operator fun rem(other: NonNegativeInt): NonNegativeInt = NonNegativeInt(this.data.rem(other.data))
    /** Calculates the remainder of dividing this value by the other value. */
    operator fun rem(other: NonNegativeLong): NonNegativeLong = this.toNonNegativeLong().rem(other)

    /** Increments this value. */
    operator fun inc(): NonNegativeInt = NonNegativeInt(data.inc())
    /** Decrements this value. */
    fun dec(): Int = data.dec()

    /** Shifts this value left by the [bitCount] number of bits. */
    infix fun shl(bitCount: Int): Int = data shl bitCount
    /** Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with zeros. */
    infix fun shr(bitCount: Int): NonNegativeInt = NonNegativeInt(data shr bitCount)
    /** Performs a bitwise AND operation between the two values. */
    infix fun and(other: NonNegativeInt): NonNegativeInt = NonNegativeInt(this.data and other.data)
    /** Performs a bitwise OR operation between the two values. */
    infix fun or(other: NonNegativeInt): NonNegativeInt = NonNegativeInt(this.data or other.data)
    /** Performs a bitwise XOR operation between the two values. */
    infix fun xor(other: NonNegativeInt): NonNegativeInt = NonNegativeInt(this.data xor other.data)
    /** Inverts the bits in this value. */
    fun inv(): Int = data.inv()

    /**
     * Converts this [NonNegativeInt] value to [Int].
     */
    fun toInt(): Int = data
    /**
     * Converts this [NonNegativeLong] value to [Long].
     *
     * The resulting `Long` value represents the same numerical value as this `NonNegativeLong`.
     *
     * The least significant 32 bits of the resulting `Long` value are the same as the bits of this `NonNegativeLong`
     * value, whereas the most significant 32 bits are filled with zeros.
     */
    fun toLong(): Long = data.toLong()

    /** Returns this value. */
    fun toNonNegativeInt(): NonNegativeInt = this
    /**
     * Converts this [NonNegativeInt] value to [NonNegativeLong].
     *
     * The resulting `NonNegativeLong` value represents the same numerical value as this `NonNegativeInt`.
     *
     * The least significant 32 bits of the resulting `NonNegativeLong` value are the same as the bits of this
     * `NonNegativeInt` value, whereas the most significant 32 bits are filled with zeros.
     */
    fun toNonNegativeLong(): NonNegativeLong = data.toNonNegativeLong()

    /**
     * Converts this [NonNegativeInt] value to [Float].
     *
     * The resulting value is the closest `Float` to this `NonNegativeInt` value.
     * In case when this `NonNegativeInt` value is exactly between two `Float`s,
     * the one with zero at least significant bit of mantissa is selected.
     */
    fun toFloat(): Float = this.toDouble().toFloat()
    /**
     * Converts this [NonNegativeInt] value to [Double].
     *
     * The resulting `Double` value represents the same numerical value as this `NonNegativeInt`.
     */
    fun toDouble(): Double = data.toDouble()

    override fun toString(): String = data.toString()
}

/**
 * Converts this [Int] value to [NonNegativeInt].
 *
 * If this value is negative, an [IllegalArgumentException] will be thrown.
 *
 * The resulting `NonNegativeInt` value has the same binary representation as this `Int` value.
 */
fun Int.toNonNegativeInt(): NonNegativeInt = NonNegativeInt(this)
/**
 * Converts this [Long] value to [NonNegativeInt].
 *
 * If this value is negative, an [IllegalArgumentException] will be thrown.
 *
 * The resulting `NonNegativeInt` value is represented by the least significant 32 bits of this `Long` value.
 */
fun Long.toNonNegativeInt(): NonNegativeInt = NonNegativeInt(this.toInt())
