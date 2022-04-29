/**
 * Created by Administrator on 2022/4/20.
 */
public class ArrayDeque<T> implements Deque<T>{
    private T[] aDeque;
    private int first, last;

    // initial the ArrayDeque
    public ArrayDeque() {
        aDeque = (T[]) new Object[8];
        first = 0;
        last = 0; // last always null
    }

    // resizing the array
    private void resizing(int s) {
        if (s <= 8) {
            return;
        }
        T[] temp = (T[]) new Object[s];

        int k = first;

        temp[k % temp.length] = aDeque[k % aDeque.length];
        k += 1;
        while (k % aDeque.length != last) {
            temp[k % temp.length] = aDeque[k % aDeque.length];
            k += 1;
        }

        aDeque = temp;
        last = k % temp.length;
        first = first % temp.length;
    }

    // add the item in front of the first
    @Override
    public void addFirst(T item) {
        first = (aDeque.length + first - 1) % aDeque.length;
        aDeque[first] = item;

        if (last == first) {
            resizing(aDeque.length * 2);
        }
    }

    @Override
    public void addLast(T item) {
        aDeque[last] = item;
        last = (last + 1) % aDeque.length;

        if (last == first) {
            resizing(aDeque.length * 2);
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return (last - first + aDeque.length) % aDeque.length;
    }

    @Override
    public T removeFirst() {
        if (size() == 0) {
            return null;
        } else {
            T tmp = aDeque[first];
            aDeque[first] = null;
            first = (first + 1) % aDeque.length;

            if (size() < aDeque.length / 4) {
                resizing(aDeque.length / 2);
            }
            return tmp;
        }
    }

    @Override
    public T removeLast() {
        if (size() == 0) {
            return null;
        } else {
            last = (last - 1 + aDeque.length) % aDeque.length;
            T tmp = aDeque[last];
            aDeque[last] = null;

            if (size() < aDeque.length / 4) {
                resizing(aDeque.length / 2);
            }
            return tmp;
        }
    }

    @Override
    public void printDeque() {
        int i = first;

        while (i != last) {
            System.out.print(aDeque[i]);
            System.out.print(' ');
            i = (i + 1) % aDeque.length;
        }
        System.out.println();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= aDeque.length) {
            return null;
        } else if (aDeque[(first + index) % aDeque.length] == null) {
            return null;
        } else {
            return aDeque[(first + index) % aDeque.length];
        }
    }
}
