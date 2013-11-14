package LinearniSeznam;

/**
 *
 * @author Johnny
 */
public class Node {

    private Node before;
    private Node after;
    private Object data;

    public Node(Object data) {
        this.before = null;
        this.after = null;
        this.data = data;
    }

    public Node(Node before, Node after, Object data) {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
