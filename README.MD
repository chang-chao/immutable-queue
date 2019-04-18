# Immutable Queue implementation.

## Java
Immutable Queue is implemented as a pair of immutable Stacks, one containing the `in` elements and the other the `out` elements.
Elements are added to the `in` stack and removed from the `out` stack.
When the `out` stack runs dry, the queue is pivoted by replacing the `out` stack by the reverse of in stack, and `in` by an empty stack.

Both Adding and Removing an item have an average time cost of O(1).

## Scala
There is built-in [Immutable Queue implementation support](https://www.scala-lang.org/api/2.12.0/scala/collection/immutable/Queue.html) in scala.
The Scala implementation uses the same idea as the Java version above, or rather, the Java implementation above borrowed the idea of Scala implementation.
