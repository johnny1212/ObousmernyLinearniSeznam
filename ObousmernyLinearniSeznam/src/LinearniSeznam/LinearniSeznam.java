package LinearniSeznam;

import java.util.Iterator;

/**
 *
 * @author Johnny
 */
public class LinearniSeznam {

    private Node first = null;
    private Node actual = null;

    public LinearniSeznam() {
    }

    public Object getFirst() {
        actual = first;
        return first.getData();
    }

    public Object getLast() {
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

    public Object getAfterActual() {
        if (first == null) {
            return null;
        }
        actual = actual.getAfter();
        if (actual == null) {
            return null;
        }
        return actual.getData();
    }

    public void addNodeFirst(Object data) {
        Node node = new Node(data);
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

    public void addNodeAfterActual(Object data) {
        if (first == null) {
            addNodeFirst(data);
            return;
        }
        Node node = new Node(data);
        if (actual.getAfter() != null) {
            actual.getAfter().setBefore(node);
            node.setAfter(actual.getAfter());
        }
        node.setBefore(actual);
        actual.setAfter(node);
        actual = node;
    }

    public void addNodeLast(Object data) {
        if (first == null) {
            addNodeFirst(data);
            return;
        }
        getLast();
        Node node = new Node(data);
        node.setBefore(actual);
        actual.setAfter(node);
        actual = node;
    }

    public Object deleteFirst() {
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
        Object data = actual.getData();
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

        private Node actual;

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
        public Object next() {
            Object puvodniData = actual.getData();
            actual = actual.getAfter();
            return puvodniData;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
