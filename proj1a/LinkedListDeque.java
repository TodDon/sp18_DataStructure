public class LinkedListDeque<T> {
    private class StuffNode {
        private T item;
        private StuffNode next;
        private StuffNode last;

        public StuffNode(T i,  StuffNode n,  StuffNode l) {
            item = i;
            next = n;
            last = l;
        }
    }

    private StuffNode hsentinel;
    private StuffNode tsentinel;
    private int size;

    public  LinkedListDeque() {
        size = 0;
        hsentinel = new StuffNode(null, null, null);
        tsentinel = new StuffNode(null, null, hsentinel);
        hsentinel.next = tsentinel;
    }

    public void addFirst(T i) {
        size += 1;
        StuffNode tmp = new StuffNode(i, hsentinel.next, hsentinel);
        hsentinel.next.last = tmp;
        hsentinel.next = tmp;
    }

    public void addLast(T i) {
        size += 1;
        StuffNode tmp = new StuffNode(i, tsentinel, tsentinel.last);
        StuffNode temp = tsentinel.last;
        temp.next  =  tmp;
        tsentinel.last = tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode p = hsentinel.next;
        System.out.println();
        while (p != tsentinel) {
            System.out.print(p.item);
            System.out.print(' ');
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        StuffNode p = hsentinel.next;
        if (p == tsentinel) {
            return null;
        } else {
            size -= 1;
            hsentinel.next = p.next;
            hsentinel.next.last = hsentinel;
            return p.item;
        }
    }

    public T removeLast() {
        StuffNode p = tsentinel.last;
        if (p == hsentinel) {
            return null;
        } else {
            size -= 1;
            tsentinel.last = p.last;
            tsentinel.last.next = tsentinel;
            return p.item;
        }
    }

    public T get(int index) {
        int i = 0;
        StuffNode p = hsentinel.next;
        while (p != tsentinel) {
            if (i == index) {
                return p.item;
            }
            i += 1;
            p = p.next;
        }
        return null;
    }

    private T forGetRecursive(StuffNode p, int index) {
        if (p == null) {
            return null;
        } else if (index == 0) {
            return p.item;
        } else {
            return forGetRecursive(p.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        return forGetRecursive(hsentinel.next, index);
    }
}
