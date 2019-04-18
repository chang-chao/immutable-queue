package queue;

import java.util.NoSuchElementException;

/**
 * Immutable Stack.
 *
 * @param <E> the type of elements held in this stack
 */
public interface ImmutableStack<E> {
  /**
   * Pushes an item onto the top of this stack.
   *
   * @param e the item to be pushed onto this stack.
   * @return the new stack after inserting the element e to the end of the stack
   */
  public ImmutableStack<E> push(E e);

  /**
   * Removes the object at the top of this stack and returns the new stack.
   *
   * @return the new stack after removing top of this stack
   * @throws NoSuchElementException if this queue is empty
   */
  public ImmutableStack<E> pop() throws NoSuchElementException;

  /**
   * Looks at the object at the top of this stack without removing it from the stack.
   *
   * @return the object at the top of this stack
   * @throws NoSuchElementException when this stack is empty
   */
  public E head() throws NoSuchElementException;

  /**
   * Tests if this stack has no elements.
   *
   * @return true when stack is empty, false otherwise
   */
  public boolean isEmpty();
}
