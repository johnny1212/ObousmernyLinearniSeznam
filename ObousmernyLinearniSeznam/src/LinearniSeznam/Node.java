package LinearniSeznam;

/**
 *
 * @author Johnny
 */
public class Node<T> {

    private Node before;
    private Node after;
    private T data;

    public Node(T data) {
        this.before = null;
        this.after = null;
        this.data = data;
    }

    public Node(Node before, Node after, T data) {
        this.before = before;
        this.after = after;
        this.data = data;
    }

    public Node getBefore() {
        return before;
    }

    public void setBefore(Node before) {
        this.before = before;
    }

    public Node getAfter() {
        return after;
    }

    public void setAfter(Node after) {
        this.after = after;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
