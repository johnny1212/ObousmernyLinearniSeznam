/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
            /* if (actual.getAfter() == null) {
             return false;
             }*/
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
