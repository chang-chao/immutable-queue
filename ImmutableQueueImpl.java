package queue;

import java.util.NoSuchElementException;

/**
 * Queue objects implement data structures that allow to insert and retrieve elements in a
 * first-in-first-out (FIFO) manner.
 *
 * <p>Queue is implemented as a pair of immutable Stacks, one containing the in elements and the
 * other the out elements. Elements are added to the in stack and removed from the out stack. When
 * the out stack runs dry, the queue is pivoted by replacing the out stack by the reverse of in
 * stack, and the in stack by an empty stack.
 *
 * @param <T> the type of elements held in this queue
 */
public class ImmutableQueueImpl<T> implements ImmutableQueue<T> {
  private final ImmutableStack<T> in;
  private final ImmutableStack<T> out;

  private ImmutableQueueImpl(ImmutableStack<T> in, ImmutableStack<T> out) {
    this.in = in;
    this.out = out;
  }

  @Override
  public ImmutableQueue<T> enQueue(T t) {
    ImmutableStack<T> inStack = this.in.push(t);
    if (this.out.isEmpty()) {
      // we should ensure out is not empty for non-empty queues
      // otherwise, head will need to get the bottom of the stack
      // which is an impossible operation for stack
      return new ImmutableQueueImpl<>(ImmutableStackImpl.EMPTY(), reverse(inStack));

    } else {
      // out is not empty
      return new ImmutableQueueImpl<>(inStack, this.out);
    }
  }

  @Override
  public ImmutableQueue<T> deQueue() throws NoSuchElementException {
    // ensure this queue is not empty
    ensureNotEmpty();
    // when this queue is not empty, we can ensure the out is not empty
    ImmutableStack<T> newOut = this.out.pop();

    if (!newOut.isEmpty()) {
      return new ImmutableQueueImpl<>(in, newOut);
    }

    // new out is empty
    // we reverse in as the new out and empty stack as the new in
    return new ImmutableQueueImpl<>(ImmutableStackImpl.EMPTY(), reverse(this.in));
  }

  private void ensureNotEmpty() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("queue is empty");
    }
  }

  private static <T> ImmutableStack<T> reverse(ImmutableStack<T> stack) {
    ImmutableStack<T> reversedStack = ImmutableStackImpl.EMPTY();
    for (ImmutableStack<T> temp = stack; !temp.isEmpty(); temp = temp.pop()) {
      reversedStack = reversedStack.push(temp.head());
    }

    return reversedStack;
  }

  @Override
  public T head() throws NoSuchElementException {
    // ensure this queue is not empty
    ensureNotEmpty();
    // when this queue is not empty, we can ensure that out is not empty
    // so we just get the head of the out
    return this.out.head();
  }

  @Override
  public boolean isEmpty() {
    // when out is empty , the queue is empty
    // we ensured that there is no case in which "in" is non-empty but "out" is empty
    return this.out.isEmpty();
  }

  @SuppressWarnings("rawtypes")
  public static final ImmutableQueue EMPTY = createEmptyQueue();

  @SuppressWarnings("unchecked")
  public static <T> ImmutableQueue<T> EMPTY() {
    return (ImmutableQueue<T>) EMPTY;
  }

  private static <T> ImmutableQueue<T> createEmptyQueue() {
    ImmutableStack<T> emptyStack = ImmutableStackImpl.EMPTY();
    return new ImmutableQueueImpl<>(emptyStack, emptyStack);
  }
}
