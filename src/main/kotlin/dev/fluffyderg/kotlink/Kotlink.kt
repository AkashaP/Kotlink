@file:Suppress("EXPERIMENTAL_API_USAGE", "OVERRIDE_BY_INLINE", "EXPERIMENTAL_UNSIGNED_LITERALS", "UNCHECKED_CAST",
	"NOTHING_TO_INLINE")

package dev.fluffyderg.kotlink

import dev.fluffyderg.kotlink.dev.fluffyderg.kotlink.internal.Link2BB
import dev.fluffyderg.kotlink.dev.fluffyderg.kotlink.internal.Link2FF
import dev.fluffyderg.kotlink.dev.fluffyderg.kotlink.internal.Link2FI
import dev.fluffyderg.kotlink.dev.fluffyderg.kotlink.internal.Link2IF
import dev.fluffyderg.kotlink.dev.fluffyderg.kotlink.internal.Link2II
import dev.fluffyderg.kotlink.dev.fluffyderg.kotlink.internal.Link2SS
import kotlin.math.abs
import kotlin.math.sign

/**
 * General use association objects that can be used in performance critical code.
 * without sacrificing object oriented API.
 * Recommend use wild star import
 *
 * Some snippets of code are used from KEEP discussion:
 * https://github.com/Kotlin/KEEP/pull/103
 */

/**
 * Public API
 */

public infix fun Int.ln(b: Int): Link2<Int, Int> {
	return Link2II.create(this, b)
}

public infix fun Float.ln(b: Int): Link2<Float, Int> {
	return Link2FI.create(this, b)
}

public infix fun Int.ln(b: Float): Link2<Int, Float> {
	return Link2IF.create(this, b)
}

public infix fun Short.ln(b: Short): Link2<Short, Short> {
	return Link2SS.create(this, b)
}

public infix fun Float.ln(b: Float): Link2<Float, Float> {
	return Link2FF.create(this, b)
}

public infix fun UInt.ln(b: UInt): Link2<UInt, UInt> {
	return Link2II.create(this.toInt(), b.toInt()) as Link2<UInt, UInt>
}

public infix fun Float.ln(b: UInt): Link2<Float, UInt> {
	return Link2FI.create(this, b.toInt()) as Link2<Float, UInt>
}

public infix fun UInt.ln(b: Float): Link2<UInt, Float> {
	return Link2IF.create(this.toInt(), b) as Link2<UInt, Float>
}

public infix fun UShort.ln(b: UShort): Link2<UShort, UShort> {
	return Link2SS.create(this.toShort(), b.toShort()) as Link2<UShort, UShort>
}

public infix fun Byte.ln(b:Byte):Link2<Byte, Byte> {
	return Link2BB.create(this, b)
}

public infix fun UByte.ln(b:UByte):Link2<UByte, UByte> {
	return Link2BB.create(this.toByte(), b.toByte()) as Link2<UByte, UByte>
}

public inline operator fun <A, B> Link2<A, B>.component1(): A =
	first

public inline operator fun <A, B> Link2<A, B>.component2(): B =
	second

public inline operator fun <A, B, C> Link3<A, B, C>.component3(): C =
	third

public inline operator fun <A, B, C, D> Link4<A, B, C, D>.component4(): D =
	fourth

public inline val <A, B> Link2<A, B>.key: A
	inline get() = first
public inline val <A, B> Link2<A, B>.value: B
	inline get() = second
public inline val <A, B> Link2<A, B>.pair: Pair<A, B>
	inline get() = first to second
public inline val <A, B> Link2<A, B>.symPair: SymPair<A, B>
	inline get() = first symTo second
public inline val <A, B> Link2<A, B>.entry: Map.Entry<A, B>
	inline get() = hashMapOf<A, B>(pair).entries.first()
public inline val <A, B, C> Link3<A, B, C>.triple: Triple<A, B, C>
	inline get() = Triple(first, second, third)
public inline val <A, B, C> Link3<A, B, C>.symTriple: SymTriple<A, B, C>
	inline get() = SymTriple(first, second, third)
public inline val <A, B, C, D> Link4<A, B, C, D>.symQuadruple: SymQuadruple<A, B, C, D>
	inline get() = SymQuadruple(first, second, third, fourth)

// Collection conversion

public typealias FloatRange = ClosedFloatingPointRange<Float>

public inline val <reified A> Link2<A, A>.array: Array<A>
	inline get() = arrayOf<A>(first, second)
public inline val Link2<Int, Int>.array: IntArray
	inline get() = intArrayOf(first, second)
public inline val Link2<Int, Int>.range: IntProgression
	inline get() = first towards second
public inline val Link2<Short, Short>.array: ShortArray
	inline get() = shortArrayOf(first, second)
public inline val Link2<Float, Float>.array: FloatArray
	inline get() = floatArrayOf(first, second)
public inline val Link2<Float, Float>.range: FloatRange
	inline get() = first towards second
public inline val Link2<Double, Double>.array: DoubleArray
	inline get() = doubleArrayOf(first, second)
public inline val <reified A> Link2<A, A>.set: Set<A>
	inline get() = setOf(first, second)
public inline val <reified A> Link2<A, A>.list: List<A>
	inline get() = listOf(first, second)


/**
 * Support for collections.
 * Avoids declaring temporary Pair objects unlike Kotlin stdlib.
 * However, primitives may still be autoboxed until valhalla.
 */

public fun <A, B> mapOf(vararg links: Link2<A, B>): Map<A, B> {
	return LinkedHashMap<A, B>(links.size).apply {
		for (ln in links)
			put(ln.first, ln.second)
	}
}

public fun <A, B> hashMapOf(vararg links: Link2<A, B>): Map<A, B> {
	return HashMap<A, B>(links.size).apply {
		for (ln in links)
			put(ln.first, ln.second)
	}
}

/**
 * Combines until and downTo
 */
public inline infix fun Int.towards(to:Int):IntProgression {
	var step = (to-this).sign
	if (step == 0) step = 1
	return IntProgression.fromClosedRange(this, to, step)
}

public inline infix fun Float.towards(to:Float):FloatRange {
	val one = if (this < to) this else to
	val two = if (this < to) to else this
	return one.rangeTo(two)
}

/**
 * Creates a symmetrical tuple of type [SymPair] from this and [that].
 *
 * This can be useful for creating Pairs where Pair<A, B> == Pair<B, A>.
 * Note that nulls are invalid, the nullability operator is for ease of use in Maps
 */
public infix fun <A, B> A?.symTo(that: B?): SymPair<A, B> = SymPair(this!!, that!!)

/**
 * A version of kotlin.Pair that considers its elements unordered.
 * i.e:
 * Pair(1, 2) != Pair(2, 1)
 * SymPair(1, 2) == SymPair(2, 1)
 */
public data class SymPair<A, B>(public var first: A, public var second: B) {
	override fun equals(other: Any?): Boolean {
		if (other is SymPair<*, *>) {
			return other.first == first && other.second == second
			|| other.second == first && other.first == second
		}
		if (other is Pair<*, *>) {
			return other.first == first && other.second == second
			|| other.second == first && other.first == second
		}
		if (other is Link2II) {
			return other.first == first && other.second == second
			|| other.second == first && other.first == second
		}
		return false
	}
	
	override fun hashCode(): Int {
		if (first is Int && second is Int)
			return 257 * first as Int + 257 * second as Int
		return super.hashCode()
	}
	
	public fun contains(any: Any): Boolean = first == any || second == any
}

/**
 * A version of kotlin.Triple that considers its elements unordered.
 * i.e:
 * Triple(1, 2, 3) != Triple(3, 2, 1)
 * SymTriple(1, 2, 3) == SymTriple(3, 2, 1)
 */
public data class SymTriple<A, B, C>(var first: A, var second: B, var third: C) {
	val elements: Array<Any> = arrayOf<Any>(first as Any, second as Any, third as Any)
	override fun equals(other: Any?): Boolean {
		if (other is SymTriple<*, *, *>) {
			return other.elements.contentEquals(elements)
		}
		if (other is Triple<*, *, *>) {
			return other.toList().containsAll(toList())
		}
		return false
	}
	
	override fun hashCode(): Int {
		var result = first?.hashCode() ?: 0
		result = 31 * result + (second?.hashCode() ?: 0)
		result = 31 * result + (third?.hashCode() ?: 0)
		return result
	}
	
	public fun toList(): List<Any> = elements.toList()
}

public data class SymQuadruple<A, B, C, D>(var first: A, var second: B, var third: C, var fourth: D) {
	val elements: Array<Any> = arrayOf<Any>(first as Any, second as Any, third as Any, fourth as Any)
	override fun equals(other: Any?): Boolean {
		if (other is SymQuadruple<*, *, *, *>) {
			return other.elements.contentEquals(elements)
		}
		return false
	}
	
	override fun hashCode(): Int {
		var result = first?.hashCode() ?: 0
		result = 31 * result + (second?.hashCode() ?: 0)
		result = 31 * result + (third?.hashCode() ?: 0)
		result = 31 * result + (fourth?.hashCode() ?: 0)
		return result
	}
	
	public fun toList(): List<Any> = toList()
}

public interface Link2<A, B> : Cloneable {
	public val first: A
	public val second: B
	public val length: UInt
	public override fun clone(): Link2<A, B>
}

public interface Link3<A, B, C> : Link2<A, B>, Cloneable {
	public val third: C
	public override fun clone(): Link3<A, B, C>
}

public interface Link4<A, B, C, D> : Link3<A, B, C>, Cloneable {
	public val fourth: D
	public override fun clone(): Link4<A, B, C, D>
}

public inline fun Link2<Number, Number>.dst(other: Link2<Number, Number>): Link2<Float, Float> =
	abs(first.toFloat() - other.first.toFloat()) ln abs(second.toFloat() - other.second.toFloat())

public inline fun Link2<Number, Number>.avg(): Float = ((first.toDouble() + second.toDouble()) / 2f).toFloat()

public inline fun Link2<Number, Number>.avg(other: Link2<Number, Number>): Link2<Float, Float> =
	((first.toDouble() + other.first.toDouble()) / 2f).toFloat() ln
	((second.toDouble() + other.second.toDouble()) / 2f).toFloat()

