/**
 * Created by Administrator on 2022/4/20.
 */
public class ArrayDeque<T> {
    private T[] aDeque;
    private int first, last;

    // initial the ArrayDeque
    public ArrayDeque() {
        aDeque = (T[]) new Object[8];
        first = 0;
        last = 0;// last always null
    }

    // resizing the array
    private void resizing(int s) {
        T[] aDeque_n = (T[]) new Object[s];

        int k = first;

        aDeque_n[k % aDeque_n.length] = aDeque[k % aDeque.length];
        k += 1;
        while (k % aDeque.length != last) {
            aDeque_n[k % aDeque_n.length] = aDeque[k % aDeque.length];
            k += 1;
        }

        aDeque = aDeque_n;
        last = k % aDeque_n.length;
        first = first % aDeque_n.length;
    }

    // add the item in front of the first
    public void addFirst(T item) {
        first = (aDeque.length + first - 1) % aDeque.length;
        aDeque[first] = item;

        if (last == first) {
            resizing(aDeque.length * 2);
        }
    }

    public void addLast(T item) {
        aDeque[last] = item;
        last = (last + 1) % aDeque.length;

        if (last == first) {
            resizing(aDeque.length * 2);
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return (last - first + aDeque.length) % aDeque.length;
    }

    public T removeFirst() {
        if (size() == 0) {
            return null;
        }
        else {
            T tmp = aDeque[first];
            aDeque[first] = null;
            first = (first + 1) % aDeque.length;

            if (size() < aDeque.length / 4) {
                resizing(aDeque.length / 2);
            }
            return tmp;
        }
    }

    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        else {
            last = (last - 1) % aDeque.length;
            T tmp = aDeque[last];
            aDeque[last] = null;

            if (size() < aDeque.length / 4) {
                resizing(aDeque.length / 2);
            }
            return tmp;
        }
    }

    public void printDeque() {
        int i = first;

        while (i != last) {
            System.out.print(aDeque[i]);
            System.out.print(' ');
            i = (i + 1) % aDeque.length;
        }
        System.out.println();
    }

    public T get(int index) {
        return aDeque[first + index] == null ? null : aDeque[first + index];
    }
    /*
    public int length() {
        return aDeque.length;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ary = new ArrayDeque<>();
        for(int i = 0; i < 500; i += 1) {
            ary.addLast(i);
        }


        System.out.println(ary.size());

        ary.printDeque();

        for (int i = 0; i < 456; i += 1) {
            System.out.print(ary.removeLast());
            System.out.print(' ');
        }

        System.out.println();
        System.out.println(ary.length());
        System.out.println(ary.size());

        ary.printDeque();

        System.out.println(ary.get(0));
    }*/
}
