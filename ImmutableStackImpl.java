package queue;

import java.util.NoSuchElementException;

/**
 * Immutable Stack Implementation.
 *
 * @param <E> the type of elements held in this stack
 */
public class ImmutableStackImpl<E> implements ImmutableStack<E> {
  private final E head;
  private final ImmutableStack<E> tail;

  private ImmutableStackImpl(E head, ImmutableStack<E> tail) {
    this.head = head;
    this.tail = tail;
  }

  @Override
  public ImmutableStack<E> push(E t) {
    return new ImmutableStackImpl<E>(t, this);
  }

  @Override
  public ImmutableStack<E> pop() throws NoSuchElementException {
    return this.tail;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public E head() throws NoSuchElementException {
    return this.head;
  }

  @SuppressWarnings("rawtypes")
  public static final ImmutableStack EMPTY = createEmptyStack();

  @SuppressWarnings("unchecked")
  public static <T> ImmutableStack<T> EMPTY() {
    return (ImmutableStack<T>) EMPTY;
  };

  private static <E> ImmutableStack<E> createEmptyStack() {
    return new ImmutableStack<E>() {

      @Override
      public ImmutableStack<E> push(E e) {
        return new ImmutableStackImpl<E>(e, this);
      }

      @Override
      public ImmutableStack<E> pop() throws NoSuchElementException {
        throw new NoSuchElementException("stack is empty");
      }

      @Override
      public E head() throws NoSuchElementException {
        throw new NoSuchElementException("stack is empty");
      }

      @Override
      public boolean isEmpty() {
        return true;
      }
    };
  }
}
