package queue;

import java.util.NoSuchElementException;

/**
 * Immutable Queue.
 *
 * @param <T> the type of elements held in this queue
 */
public interface ImmutableQueue<T> {
  /**
   * Inserts the specified element into this immutable queue, and returns the new queue.
   *
   * @param t the element to add
   * @return the new queue after inserting.
   */
  public ImmutableQueue<T> enQueue(T t);

  /**
   * Removes the element at the beginning of the immutable queue, and returns the new queue.
   *
   * @return the new queue
   * @throws NoSuchElementException if this queue is empty
   */
  public ImmutableQueue<T> deQueue() throws NoSuchElementException;

  /**
   * Retrieves the head of this queue, or returns null if this queue is empty.
   *
   * @return the head of this queue
   * @throws NoSuchElementException if this queue is empty
   */
  public T head() throws NoSuchElementException;

  /**
   * Tests if this queue has no elements.
   *
   * @return true if this queue contains no elements
   */
  public boolean isEmpty();
}
