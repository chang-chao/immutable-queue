package queue;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class ImmutableQueueImplTests {

  @Test
  public void emptyQueue_isEmpty() {
    Assert.assertTrue(ImmutableQueueImpl.EMPTY.isEmpty());
  }

  @Test(expected = NoSuchElementException.class)
  public void emptyQueue_cant_deQueue() {
    ImmutableQueueImpl.EMPTY.deQueue();
  }

  @Test(expected = NoSuchElementException.class)
  public void emptyQueue_cant_getHead() {
    ImmutableQueueImpl.EMPTY.head();
  }

  @Test
  public void emptyQueue_enqueue_null() {
    ImmutableQueue<Integer> empty = ImmutableQueueImpl.EMPTY();
    ImmutableQueue<Integer> queue1 = empty.enQueue(null);
    Assert.assertNull(queue1.head());
  }

  @Test
  public void emptyQueue_enqueue_nonnull() {
    ImmutableQueue<Integer> empty = ImmutableQueueImpl.EMPTY();
    ImmutableQueue<Integer> queue1 = empty.enQueue(1);
    Assert.assertEquals(1, (int) queue1.head());
  }

  @Test
  public void non_empty_queue_is_not_empty() {
    ImmutableQueue<Integer> empty = ImmutableQueueImpl.EMPTY();
    ImmutableQueue<Integer> queue1 = empty.enQueue(1);
    Assert.assertFalse(queue1.isEmpty());
  }

  @Test
  public void non_empty_queue_enqueue() {
    ImmutableQueue<Integer> empty = ImmutableQueueImpl.EMPTY();
    ImmutableQueue<Integer> queue2 = empty.enQueue(1).enQueue(2);
    Assert.assertEquals(1, (int) queue2.head());
  }

  @Test
  public void non_empty_queue_dequeue() {
    ImmutableQueue<Integer> empty = ImmutableQueueImpl.EMPTY();
    ImmutableQueue<Integer> queue1 = empty.enQueue(1);
    ImmutableQueue<Integer> empty2 = queue1.deQueue();
    Assert.assertTrue(empty2.isEmpty());
  }

  @Test
  public void non_empty_queue_enqueue_dequeue() {
    ImmutableQueue<Integer> empty = ImmutableQueueImpl.EMPTY();
    ImmutableQueue<Integer> queue1 = empty.enQueue(1).deQueue().enQueue(2).enQueue(3);
    Assert.assertEquals(2, (int) queue1.head());
  }
}
