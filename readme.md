# Kotlink
A small library for handling associations with simple primitives.
As this is mostly a quality of life/syntactical sugar 'performance' library, (almost) everything is inline
Most functionality is given from the `ln` infix function which mirrors the `to` infix function in the standard library.

## Why

idk lol.
Kotlin's standard library for maps relies heavily on the use of Pair objects, which are usually temporary constructs. The standard Pair in Kotlin is an extremely ubiquitous and general purpose construct that can tend to be used everywhere so the idea is a more optimised version of Pair is to be able to use it anywhere guilt-free without worrying about garbage collection stress.

*For example* the code:
`val mappy = mapOf(1 to 2, 2 to 3, 3 to 4)`
creates 3 Pair objects holding int primitives that are garbage as soon as the map is finished creating. 

Using Kotlink, the code:
`val mappy = mapOf(1 ln 2, 2 ln 3, 3 ln 4)`
avoids declaring any intermediate objects, as the integers are packed into primitive longs. The infix ln function returns an inlined implementation of the Link interface which has a few virtual methods defined for practical usability as if it was just a regular Pair object (theoretically, if the kotlin compiler supports it).

Link instances are cloneable and have nice toString() output.

## Example Usage
```
val a = (1 ln 2)
val b = (1 to 2)
a.first
b.first

val (c, d) = a
val (e, f) = b

// Few additionals
a.key
a.value
a.pair
a.range
```
## Other goodies
- SymPair class: Variant of Pair class that does not care for ordering of items
```
(1 to 2) == (2 to 1) // false
(1 symTo 2) == (2 symTo 1) // true
```
*(Probably more useful than the library itself but)*
- maff: `(1 ln 4) * 2 == (2, 8)`...
- Support for floats
- Some support for even smaller types like byte and short, where 2 bytes get packed into short and 2 shorts get packed into ints etc.

## Notes
- This library uses experimental Kotlin features like inline classes (currently alpha) and unsigned types
- This library does not support Long or Double (higher than 32 bits)
