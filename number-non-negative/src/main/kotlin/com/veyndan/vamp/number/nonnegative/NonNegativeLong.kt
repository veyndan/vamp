package com.veyndan.vamp.number.nonnegative

/**
 * [ULong] provide no guarantee that its backing value was originally a non-negative number. For example,
 * `(-1).toULong()` actually stores the maximum [ULong] that can be stored. Unsigned numbers are useful for algorithmic
 * optimisations, whereas [NonNegativeLong] is useful for domain driven modelling.
 *
 * The name `NaturalNumber` was not used due to the ambiguity of the allowable range including or excluding zero.
 */
class NonNegativeLong @PublishedApi internal constructor(@PublishedApi internal val data: Long) : Comparable<NonNegativeLong> {

    companion object {

        /**
         * A constant holding the minimum value an instance of [NonNegativeLong] can have.
         */
        val MIN_VALUE: NonNegativeLong = NonNegativeLong(0)

        /**
         * A constant holding the maximum value an instance of [NonNegativeLong] can have.
         */
        val MAX_VALUE: NonNegativeLong = NonNegativeLong(Long.MAX_VALUE)
    }

    init {
        require(data >= 0) { "$data is negative" }
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: NonNegativeInt): Int = this.compareTo(other.toNonNegativeLong())

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: NonNegativeLong): Int = this.data.compareTo(other.data)

    /** Adds the other value to this value. */
    operator fun plus(other: NonNegativeInt): NonNegativeLong = this.plus(other.toNonNegativeLong())
    /** Adds the other value to this value. */
    operator fun plus(other: NonNegativeLong): NonNegativeLong = NonNegativeLong(this.data.plus(other.data))

    /** Subtracts the other value from this value. */
    operator fun minus(other: NonNegativeInt): Long = this.minus(other.toNonNegativeLong())
    /** Subtracts the other value from this value. */
    operator fun minus(other: NonNegativeLong): Long = this.data.minus(other.data)

    /** Multiplies this value by the other value. */
    operator fun times(other: NonNegativeInt): NonNegativeLong = this.times(other.toNonNegativeLong())
    /** Multiplies this value by the other value. */
    operator fun times(other: NonNegativeLong): NonNegativeLong = NonNegativeLong(this.data.times(other.data))

    /** Divides this value by the other value. */
    operator fun div(other: NonNegativeInt): NonNegativeLong = this.div(other.toNonNegativeLong())
    /** Divides this value by the other value. */
    operator fun div(other: NonNegativeLong): NonNegativeLong = NonNegativeLong(this.data / other.data)

    /** Calculates the remainder of dividing this value by the other value. */
    operator fun rem(other: NonNegativeInt): NonNegativeLong = this.rem(other.toNonNegativeLong())
    /** Calculates the remainder of dividing this value by the other value. */
    operator fun rem(other: NonNegativeLong): NonNegativeLong = NonNegativeLong(this.data.rem(other.data))

    /** Increments this value. */
    operator fun inc(): NonNegativeLong = NonNegativeLong(data.inc())
    /** Decrements this value. */
    fun dec(): Long = data.dec()

    /** Shifts this value left by the [bitCount] number of bits. */
    infix fun shl(bitCount: Int): Long = data shl bitCount
    /** Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with zeros. */
    infix fun shr(bitCount: Int): NonNegativeLong = NonNegativeLong(data shr bitCount)
    /** Performs a bitwise AND operation between the two values. */
    infix fun and(other: NonNegativeLong): NonNegativeLong = NonNegativeLong(this.data and other.data)
    /** Performs a bitwise OR operation between the two values. */
    infix fun or(other: NonNegativeLong): NonNegativeLong = NonNegativeLong(this.data or other.data)
    /** Performs a bitwise XOR operation between the two values. */
    infix fun xor(other: NonNegativeLong): NonNegativeLong = NonNegativeLong(this.data xor other.data)
    /** Inverts the bits in this value. */
    fun inv(): Long = data.inv()

    /**
     * Converts this [NonNegativeLong] value to [Int].
     *
     * If this value is less than or equals to [Int.MAX_VALUE], the resulting `Int` value represents
     * the same numerical value as this `NonNegativeLong`.
     *
     * The resulting `Int` value is represented by the least significant 32 bits of this `NonNegativeLong` value.
     */
    fun toInt(): Int = data.toInt()
    /**
     * Converts this [NonNegativeLong] value to [Long].
     */
    fun toLong(): Long = data

    /**
     * Converts this [NonNegativeLong] value to [NonNegativeInt].
     *
     * If this value is less than or equals to [NonNegativeInt.MAX_VALUE], the resulting `NonNegativeInt` value
     * represents the same numerical value as this `NonNegativeLong`.
     *
     * The resulting `NonNegativeInt` value is represented by the least significant 32 bits of this `NonNegativeLong`
     * value.
     */
    fun toNonNegativeInt(): NonNegativeInt = data.toNonNegativeInt()
    /** Returns this value. */
    fun toNonNegativeLong(): NonNegativeLong = this

    /**
     * Converts this [NonNegativeLong] value to [Float].
     *
     * The resulting value is the closest `Float` to this `NonNegativeLong` value.
     * In case when this `NonNegativeLong` value is exactly between two `Float`s,
     * the one with zero at least significant bit of mantissa is selected.
     */
    fun toFloat(): Float = this.toDouble().toFloat()
    /**
     * Converts this [NonNegativeLong] value to [Double].
     *
     * The resulting value is the closest `Double` to this `NonNegativeLong` value.
     * In case when this `NonNegativeLong` value is exactly between two `Double`s,
     * the one with zero at least significant bit of mantissa is selected.
     */
    fun toDouble(): Double = data.toDouble()

    override fun toString(): String = data.toString()

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other is NonNegativeLong -> data == other.data
        else -> false
    }

    override fun hashCode(): Int = data.hashCode()
}

/**
 * Converts this [Int] value to [NonNegativeLong].
 *
 * If this value is negative, an [IllegalArgumentException] will be thrown.
 *
 * The least significant 32 bits of the resulting `NonNegativeLong` value are the same as the bits of this `Int` value,
 * whereas the most significant 32 bits are filled with the sign bit of this value.
 */
fun Int.toNonNegativeLong(): NonNegativeLong = NonNegativeLong(this.toLong())
/**
 * Converts this [Long] value to [NonNegativeLong].
 *
 * If this value is negative, an [IllegalArgumentException] will be thrown.
 *
 * The resulting `NonNegativeLong` value has the same binary representation as this `Long` value.
 */
fun Long.toNonNegativeLong(): NonNegativeLong = NonNegativeLong(this)
