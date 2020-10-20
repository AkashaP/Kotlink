@file:Suppress("EXPERIMENTAL_API_USAGE", "OVERRIDE_BY_INLINE", "EXPERIMENTAL_UNSIGNED_LITERALS", "UNCHECKED_CAST",
	"NOTHING_TO_INLINE")

package dev.fluffyderg.kotlink

import dev.fluffyderg.kotlink.Link2
import dev.fluffyderg.kotlink.ln
import kotlin.math.abs

// quick maff 
@JvmName("plusIntIntInt")
public inline operator fun Link2<Int, Int>.plus(a: Int): Link2<Int, Int> = (first + a) ln (second + a)

@JvmName("plusIntShortShort")
public inline operator fun Link2<Short, Short>.plus(a: Int): Link2<Short, Short> =
	(first + a).toShort() ln (second + a).toShort()

@JvmName("plusIntFloatFloat")
public inline operator fun Link2<Float, Float>.plus(a: Int): Link2<Float, Float> =
	(first + a).toFloat() ln (second + a).toFloat()

@JvmName("plusIntByteByte")
public inline operator fun Link2<Byte, Byte>.plus(a: Int): Link2<Byte, Byte> =
	(first + a).toByte() ln (second + a).toByte()

@JvmName("plusIntUIntUInt")
public inline operator fun Link2<UInt, UInt>.plus(a: Int): Link2<UInt, UInt> =
	(first + a.toUInt()) ln (second + a.toUInt())

@JvmName("plusIntUShortUShort")
public inline operator fun Link2<UShort, UShort>.plus(a: Int): Link2<UShort, UShort> =
	(first + a.toUInt()).toUShort() ln (second + a.toUInt()).toUShort()

@JvmName("plusIntUByteUByte")
public inline operator fun Link2<UByte, UByte>.plus(a: Int): Link2<UByte, UByte> =
	(first + a.toUInt()).toUByte() ln (second + a.toUInt()).toUByte()

@JvmName("plusIntIntFloat")
public inline operator fun Link2<Int, Float>.plus(a: Int): Link2<Int, Float> =
	(first + a) ln (second + a).toFloat()

@JvmName("plusIntFloatInt")
public inline operator fun Link2<Float, Int>.plus(a: Int): Link2<Float, Int> =
	(first + a).toFloat() ln (second + a)

@JvmName("timesIntIntInt")
public inline operator fun Link2<Int, Int>.times(a: Int): Link2<Int, Int> = (first * a) ln (second * a)

@JvmName("timesIntShortShort")
public inline operator fun Link2<Short, Short>.times(a: Int): Link2<Short, Short> =
	(first * a).toShort() ln (second * a).toShort()

@JvmName("timesIntFloatFloat")
public inline operator fun Link2<Float, Float>.times(a: Int): Link2<Float, Float> =
	(first * a).toFloat() ln (second * a).toFloat()

@JvmName("timesIntByteByte")
public inline operator fun Link2<Byte, Byte>.times(a: Int): Link2<Byte, Byte> =
	(first * a).toByte() ln (second * a).toByte()

@JvmName("timesIntUIntUInt")
public inline operator fun Link2<UInt, UInt>.times(a: Int): Link2<UInt, UInt> =
	(first * a.toUInt()) ln (second * a.toUInt())

@JvmName("timesIntUShortUShort")
public inline operator fun Link2<UShort, UShort>.times(a: Int): Link2<UShort, UShort> =
	(first * a.toUInt()).toUShort() ln (second * a.toUInt()).toUShort()

@JvmName("timesIntUByteUByte")
public inline operator fun Link2<UByte, UByte>.times(a: Int): Link2<UByte, UByte> =
	(first * a.toUInt()).toUByte() ln (second * a.toUInt()).toUByte()

@JvmName("timesIntIntFloat")
public inline operator fun Link2<Int, Float>.times(a: Int): Link2<Int, Float> =
	(first * a) ln (second * a).toFloat()

@JvmName("timesIntFloatInt")
public inline operator fun Link2<Float, Int>.times(a: Int): Link2<Float, Int> =
	(first * a).toFloat() ln (second * a)

@JvmName("minusIntIntInt")
public inline operator fun Link2<Int, Int>.minus(a: Int): Link2<Int, Int> = (first - a) ln (second - a)

@JvmName("minusIntShortShort")
public inline operator fun Link2<Short, Short>.minus(a: Int): Link2<Short, Short> =
	(first - a).toShort() ln (second - a).toShort()

@JvmName("minusIntFloatFloat")
public inline operator fun Link2<Float, Float>.minus(a: Int): Link2<Float, Float> =
	(first - a).toFloat() ln (second - a).toFloat()

@JvmName("minusIntByteByte")
public inline operator fun Link2<Byte, Byte>.minus(a: Int): Link2<Byte, Byte> =
	(first - a).toByte() ln (second - a).toByte()

@JvmName("minusIntUIntUInt")
public inline operator fun Link2<UInt, UInt>.minus(a: Int): Link2<UInt, UInt> =
	(first - a.toUInt()) ln (second - a.toUInt())

@JvmName("minusIntUShortUShort")
public inline operator fun Link2<UShort, UShort>.minus(a: Int): Link2<UShort, UShort> =
	(first - a.toUInt()).toUShort() ln (second - a.toUInt()).toUShort()

@JvmName("minusIntUByteUByte")
public inline operator fun Link2<UByte, UByte>.minus(a: Int): Link2<UByte, UByte> =
	(first - a.toUInt()).toUByte() ln (second - a.toUInt()).toUByte()

@JvmName("minusIntIntFloat")
public inline operator fun Link2<Int, Float>.minus(a: Int): Link2<Int, Float> =
	(first - a) ln (second - a).toFloat()

@JvmName("minusIntFloatInt")
public inline operator fun Link2<Float, Int>.minus(a: Int): Link2<Float, Int> =
	(first - a).toFloat() ln (second - a)

@JvmName("divIntIntInt")
public inline operator fun Link2<Int, Int>.div(a: Int): Link2<Int, Int> = (first / a) ln (second / a)

@JvmName("divIntShortShort")
public inline operator fun Link2<Short, Short>.div(a: Int): Link2<Short, Short> =
	(first / a).toShort() ln (second / a).toShort()

@JvmName("divIntFloatFloat")
public inline operator fun Link2<Float, Float>.div(a: Int): Link2<Float, Float> =
	(first / a).toFloat() ln (second / a).toFloat()

@JvmName("divIntByteByte")
public inline operator fun Link2<Byte, Byte>.div(a: Int): Link2<Byte, Byte> =
	(first / a).toByte() ln (second / a).toByte()

@JvmName("divIntUIntUInt")
public inline operator fun Link2<UInt, UInt>.div(a: Int): Link2<UInt, UInt> =
	(first / a.toUInt()) ln (second / a.toUInt())

@JvmName("divIntUShortUShort")
public inline operator fun Link2<UShort, UShort>.div(a: Int): Link2<UShort, UShort> =
	(first / a.toUInt()).toUShort() ln (second / a.toUInt()).toUShort()

@JvmName("divIntUByteUByte")
public inline operator fun Link2<UByte, UByte>.div(a: Int): Link2<UByte, UByte> =
	(first / a.toUInt()).toUByte() ln (second / a.toUInt()).toUByte()

@JvmName("divIntIntFloat")
public inline operator fun Link2<Int, Float>.div(a: Int): Link2<Int, Float> =
	(first / a) ln (second / a).toFloat()

@JvmName("divIntFloatInt")
public inline operator fun Link2<Float, Int>.div(a: Int): Link2<Float, Int> =
	(first / a).toFloat() ln (second / a)

@JvmName("remIntIntInt")
public inline operator fun Link2<Int, Int>.rem(a: Int): Link2<Int, Int> = (first % a) ln (second % a)

@JvmName("remIntShortShort")
public inline operator fun Link2<Short, Short>.rem(a: Int): Link2<Short, Short> =
	(first % a).toShort() ln (second % a).toShort()

@JvmName("remIntFloatFloat")
public inline operator fun Link2<Float, Float>.rem(a: Int): Link2<Float, Float> =
	(first % a).toFloat() ln (second % a).toFloat()

@JvmName("remIntByteByte")
public inline operator fun Link2<Byte, Byte>.rem(a: Int): Link2<Byte, Byte> =
	(first % a).toByte() ln (second % a).toByte()

@JvmName("remIntUIntUInt")
public inline operator fun Link2<UInt, UInt>.rem(a: Int): Link2<UInt, UInt> =
	(first % a.toUInt()) ln (second % a.toUInt())

@JvmName("remIntUShortUShort")
public inline operator fun Link2<UShort, UShort>.rem(a: Int): Link2<UShort, UShort> =
	(first % a.toUInt()).toUShort() ln (second % a.toUInt()).toUShort()

@JvmName("remIntUByteUByte")
public inline operator fun Link2<UByte, UByte>.rem(a: Int): Link2<UByte, UByte> =
	(first % a.toUInt()).toUByte() ln (second % a.toUInt()).toUByte()

@JvmName("remIntIntFloat")
public inline operator fun Link2<Int, Float>.rem(a: Int): Link2<Int, Float> =
	(first % a) ln (second % a).toFloat()

@JvmName("remIntFloatInt")
public inline operator fun Link2<Float, Int>.rem(a: Int): Link2<Float, Int> =
	(first % a).toFloat() ln (second % a)