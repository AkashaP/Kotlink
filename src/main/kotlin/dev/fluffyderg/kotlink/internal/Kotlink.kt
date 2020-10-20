@file:Suppress("EXPERIMENTAL_API_USAGE", "OVERRIDE_BY_INLINE", "EXPERIMENTAL_UNSIGNED_LITERALS", "UNCHECKED_CAST",
	"NOTHING_TO_INLINE")

package dev.fluffyderg.kotlink.dev.fluffyderg.kotlink.internal

import dev.fluffyderg.kotlink.*

internal inline class Link2II(
	@PublishedApi
	internal val both: Long,
) : Link2<Int, Int> {
	public override inline val first: Int
		inline get() = both.toInt()
	public override inline val second: Int
		inline get() = (both ushr 32).toInt()
	override val length: UInt
		inline get() = 64u
	
	override fun toString(): String {
		return "($first, $second)"
	}
	
	override fun clone(): Link2<Int, Int> =
		Link2II(both)
	
	public companion object {
		public fun create(a: Int, b: Int): Link2II =
			Link2II(b.toLong() shl 32 or (a.toLong() shl 32 ushr 32))
	}
}

internal inline class Link2IF(
	@PublishedApi
	internal val both: Long,
) : Link2<Int, Float> {
	public override inline val first: Int
		inline get() = both.toInt()
	public override inline val second: Float
		inline get() = java.lang.Float.intBitsToFloat((both ushr 32).toInt())
	override val length: UInt
		inline get() = 64u
	
	override fun toString(): String {
		return "($first, $second)"
	}
	
	override fun clone(): Link2<Int, Float> =
		Link2IF(both)
	
	public companion object {
		public fun create(a: Int, b: Float): Link2IF =
			Link2IF(java.lang.Float.floatToIntBits(b).toLong() shl 32 or (a.toLong() shl 32 ushr 32))
	}
}

internal inline class Link2FI(
	@PublishedApi
	internal val both: Long,
) : Link2<Float, Int> {
	public override inline val first: Float
		inline get() = java.lang.Float.intBitsToFloat((both).toInt())
	public override inline val second: Int
		inline get() = (both ushr 32).toInt()
	override val length: UInt
		inline get() = 64u
	
	override fun toString(): String {
		return "($first, $second)"
	}
	
	override fun clone(): Link2<Float, Int> =
		Link2FI(both)
	
	public companion object {
		public fun create(a: Float, b: Int): Link2FI =
			Link2FI(b.toLong() shl 32 or (java.lang.Float.floatToIntBits(a).toLong() shl 32 ushr 32))
	}
}

internal inline class Link2FF(
	@PublishedApi
	internal val both: Long,
) : Link2<Float, Float> {
	public override inline val first: Float
		inline get() = java.lang.Float.intBitsToFloat((both).toInt())
	public override inline val second: Float
		inline get() = java.lang.Float.intBitsToFloat((both ushr 32).toInt())
	override val length: UInt
		inline get() = 64u
	
	override fun toString(): String {
		return "($first, $second)"
	}
	
	override fun clone(): Link2<Float, Float> =
		Link2FF(both)
	
	public companion object {
		public fun create(a: Float, b: Float): Link2FF =
			Link2FF(java.lang.Float.floatToIntBits(b).toLong() shl 32 or (java.lang.Float.floatToIntBits(a)
				.toLong() shl 32 ushr 32))
	}
}

internal inline class Link2SS(
	@PublishedApi
	internal val both: Int,
) : Link2<Short, Short> {
	public override inline val first: Short
		inline get() = both.toShort()
	public override inline val second: Short
		inline get() = (both ushr 16).toShort()
	override val length: UInt
		inline get() = 32u
	
	override fun toString(): String {
		return "($first, $second)"
	}
	
	override fun clone(): Link2<Short, Short> =
		Link2SS(both)
	
	public companion object {
		public fun create(a: Short, b: Short): Link2SS =
			Link2SS(b.toInt() shl 16 or (a.toInt() shl 48 ushr 48))
	}
}

internal inline class Link2BB(
	@PublishedApi
	internal val both: Short,
) : Link2<Byte, Byte> {
	public override inline val first: Byte
		inline get() = both.toByte()
	public override inline val second: Byte
		inline get() = (both.toInt() ushr 8).toByte()
	override val length: UInt
		inline get() = 16u
	
	override fun toString(): String {
		return "($first, $second)"
	}
	
	override fun clone(): Link2<Byte, Byte> =
		Link2BB(both)
	
	public companion object {
		public fun create(a: Byte, b: Byte): Link2BB =
			Link2BB((b.toInt() shl 8 or (a.toInt() shl 56 ushr 56)).toShort())
	}
}

private const val docAA = """
	This is currently unsupported. It would have been implemented via array backing.
	However, it is not very usable since the hashCode and equals method of inline classes cannot be overridden.
	This means it cannot be effectively used in collections because mapOf((1, 2))[(1, 2)] == null
	Use Pair for now instead.
"""

/**
 * {@value #docAA}
 */
@Deprecated(docAA, replaceWith = ReplaceWith("#Pair"), DeprecationLevel.ERROR)
internal inline class Link2AA<A : Any, b : Any>(public val f: Any)