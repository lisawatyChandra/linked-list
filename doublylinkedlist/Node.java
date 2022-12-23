package doublylinkedlist;

/**
 * The node contains two elements: data and a link to the next node.
 * The node has pointer to the previous node as well as the next node.
 */
public class Node {
    public String data;
    private Node next;
    private Node previous;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public void setNextNode(Node node) {
        this.next = node;
    }

    public void setPreviousNode(Node node) {
        this.previous = node;
    }

    public Node getNextNode() {
        return this.next;
    }

    public Node getPreviousNode() {
        return this.previous;
    }
}
