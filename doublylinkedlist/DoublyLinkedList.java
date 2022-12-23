package doublylinkedlist;

/**
 * A doubly linked list is a sequential chain of nodes, just like
 * a singly linked list. A doubly linked list has a tail property
 * in addition to a head property.
 */
public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToHead(String data) {
        // create the new node that will be added to the head of the list
        Node newHead = new Node(data);
        // assign a pointer to the current head
        Node currentHead = this.head;

        // if the list is not empty
        if (currentHead != null) {
            // reset the pointers at the head of the list:
            // set the current head's previous node to the new head
            currentHead.setPreviousNode(newHead);
            // set the new head's next node to the current head
            newHead.setNextNode(currentHead);
        }

        // if the list is empty, update the head property to be the new head
        this.head = newHead;

        // if the list is empty, update the tail property to be the new head
        // since that node will be both the head and the tail
        if (this.tail == null) {
            this.tail = newHead;
        }
    }

    public void addToTail(String data) {
        Node newTail = new Node(data);
        Node currentTail = this.tail;

        if (currentTail != null) {
            currentTail.setNextNode(newTail);
            newTail.setPreviousNode(currentTail);
        }
        this.tail = newTail;

        if (this.head == null) {
            this.head = newTail;
        }
    }

    public String removeHead() {
        Node removedHead = this.head;

        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNextNode();

        if (this.head != null) {
            this.head.setPreviousNode(null);
        }

        if (removedHead == this.tail) {
            this.removeTail();
        }

        return removedHead.data;
    }

    public String removeTail() {
        Node removedTail = this.tail;

        if (removedTail == null) {
            return null;
        }

        this.tail = removedTail.getPreviousNode();
        if (this.tail != null) {
            this.tail.setNextNode(null);
        }

        if (removedTail == this.head) {
            this.removeHead();
        }

        return removedTail.data;
    }

    public Node removeByData(String data) {
        Node nodeToRemove = null;
        Node currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.data == data) {
                nodeToRemove = currentNode;
                break;
            }
            currentNode = currentNode.getNextNode();
        }

        if (nodeToRemove == null) {
            return null;
        }

        if (nodeToRemove == this.head) {
            this.removeHead();
        } else if (nodeToRemove == this.tail) {
            this.removeTail();
        } else {
            Node nextNode = nodeToRemove.getNextNode();
            Node previousNode = nodeToRemove.getPreviousNode();
            nextNode.setPreviousNode(previousNode);
            previousNode.setNextNode(nextNode);
        }

        return nodeToRemove;
    }

    public String printList() {
        Node currentNode = this.head;
        String output = "<head> ";

        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tails>";
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        // Create your subway line here:
        DoublyLinkedList subway = new DoublyLinkedList();
        subway.addToHead("Times Square");
        subway.addToHead("Grand Central");
        subway.addToHead("Central Park");
        subway.printList();
        subway.addToTail("Penn Station");
        subway.addToTail("Wall Street");
        subway.addToTail("Brooklyn Bridge");
        subway.printList();
        subway.removeHead();
        subway.removeTail();
        subway.printList();
        subway.removeByData("Times Square");
        subway.printList();
    }
}
