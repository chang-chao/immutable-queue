# Immutable Queue implementation.

## Java
Immutable Queue is implemented as a pair of immutable Stacks, one containing the `in` elements and the other the `out` elements.
Elements are added to the `in` stack and removed from the `out` stack.
When the `out` stack runs dry, the queue is pivoted by replacing the `out` stack by the reverse of in stack, and `in` by an empty stack.

Adding items to the queue always has cost O(1).

Removing items has cost O(1), except in the case where a pivot is required, in which case, a cost of O(n) is incurred, where n is the number of elements in the queue. When this happens, n remove operations with O(1) cost are guaranteed. Removing an item is on average O(1).

## Scala
There is built-in [Immutable Queue implementation support](https://www.scala-lang.org/api/2.12.0/scala/collection/immutable/Queue.html) in scala.
The Scala implementation uses the same idea as the Java version above, or rather, the Java implementation above borrowed the idea of Scala implementation.

## Differences between Java and Scala implementation.
Scala implementation uses a a pair of lists, and we can get the head and tail of a list, so we can always add element to the `in` list.

Java implementation differs a bit with Scala in that, we should ensure that the `out` stack should never be empty for an non-empty queue.
So when the first element is added to the queue, we should add it to the `out` stack, instead of `in`.
Because Java version uses immutable stacks internally, where it's impossible to get the `bottom` element, so the implementation avoids the case in which the `in` stack is not empty while the `out` stack is empty, making peeking the head of the queue(the bottom of a stack) impossible.
