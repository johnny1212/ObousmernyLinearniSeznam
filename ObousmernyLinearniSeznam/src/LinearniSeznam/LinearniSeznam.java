package LinearniSeznam;

import java.util.Iterator;

/**
 *
 * @author Johnny
 */
public class LinearniSeznam<T> {

    private Node<T> first = null;
    private Node<T> actual = null;

    public LinearniSeznam() {
    }

    public T getFirst() {
        actual = first;
        return first.getData();
    }

    public T getActual() {
        return actual.getData();
    }

    public T getLast() {
        if (first == null) {
            return null;
        }
        actual = first;
        while (actual != null) {
            if (actual.getAfter() == null) {
                return actual.getData();
            }
            actual = actual.getAfter();
        }
        actual = first;
        return first.getData();
    }

    public T getAfterActual() {
        if (first == null) {
            return null;
        }
        actual = actual.getAfter();
        if (actual == null) {
            return null;
        }
        return actual.getData();
    }

    public void addNodeFirst(T data) {
        Node<T> node = new Node<T>(data);
        if (first == null) {
            first = node;
            actual = node;
            return;
        }
        node.setAfter(first);
        first.setBefore(node);
        first = node;
        actual = node;
    }

    public void addNodeAfterActual(T data) {
        if (first == null) {
            addNodeFirst(data);
            return;
        }
        Node<T> node = new Node<T>(data);
        if (actual.getAfter() != null) {
            actual.getAfter().setBefore(node);
            node.setAfter(actual.getAfter());
        }
        node.setBefore(actual);
        actual.setAfter(node);
        actual = node;
    }

    public void addNodeLast(T data) {
        if (first == null) {
            addNodeFirst(data);
            return;
        }
        getLast();
        Node<T> node = new Node<T>(data);
        node.setBefore(actual);
        actual.setAfter(node);
        actual = node;
    }

    public T deleteFirst() {
        if (first == null) {
            return null;
        }
        actual = first;
        if (actual.getAfter() != null) {
            first = actual.getAfter();
            first.setBefore(null);
        } else {
            first = null;
        }
        actual.setAfter(null);
        T data = actual.getData();
        actual = first;
        return data;
    }

    /*public void vypis() {
     actual = first;
     while (actual != null) {
     System.out.println("-" + actual.getData());
     actual = actual.getAfter();
     }
     }*/
    public Iterator getIterator() {
        return new Iter();
    }

    private class Iter implements Iterator {

        private Node<T> actual;

        public Iter() {
            actual = first;
        }

        @Override
        public boolean hasNext() {
            if (actual == null) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            T puvodniData = actual.getData();
            actual = actual.getAfter();
            return puvodniData;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
