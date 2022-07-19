package synthesizer;

import java.util.Iterator;

/**
 * Created by Administrator on 2022/7/7.
 */
public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();    // return size of the buffer

    int fillCount();   // return number of items currently

    void enqueue(T x); // add item x to the end

    T dequeue();       // delete and return item from the front

    T peek();          // return item from the front

    default boolean isEmpty() {
        return fillCount() == 0;
    }

    Iterator<T> iterator();

    default boolean isFull() {
        return fillCount() == capacity();
    }
}
