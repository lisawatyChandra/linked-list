package singlylinkedlist;

public class LinkedList {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(String data) {
        // create a new node that will be added to the head of the list
        // assign a pointer to this new node, we'll call the pointer
        // newHead
        Node newHead = new Node(data);
        // assign a pointer to the current head, we'll call this pointer
        // currentHead
        Node currentHead = this.head;
        // assign this list's current head to newHead
        this.head = newHead;

        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(String data) {
        Node tail = this.head;

        if (tail == null) {
            this.head = new Node(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node(data));
        }
    }

    public String removeHead() {
        Node removedHead = this.head;

        if (removedHead == null) {
            return null;
        }

        this.head = removedHead.getNextNode();

        return removedHead.data;
    }

    public String printList() {
        String output = "<head> ";
        Node currentNode = this.head;

        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {

        LinkedList seasons = new LinkedList();
        seasons.printList();
        seasons.addToHead("summer");
        seasons.addToHead("spring");
        seasons.printList();
        seasons.addToTail("fall");
        seasons.addToTail("winter");
        seasons.printList();
        seasons.removeHead();
        seasons.printList();
    }
}
