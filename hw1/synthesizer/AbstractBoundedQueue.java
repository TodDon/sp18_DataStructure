package synthesizer;

/**
 * Created by Administrator on 2022/7/7.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;
    public int capacity() {
        return capacity;
    }

    public int fillCount() {
        return fillCount;
    }
//    public boolean isEmpty() {
//        return 0 == fillCount;
//    }
//    public boolean isFull() {
//        return fillCount == capacity;
//    }
//    public abstract T peek();
//    public abstract T dequeue();
//    public abstract void enqueue(T x);
}
