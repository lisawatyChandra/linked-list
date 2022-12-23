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

        // update the head property to be the new head
        this.head = newHead;

        // if the list is empty, update the tail property to be the new head
        // since that node will be both the head and the tail
        if (this.tail == null) {
            this.tail = newHead;
        }
    }

    public void addToTail(String data) {
        // create the new node that will be added to the tail of the list
        Node newTail = new Node(data);
        // assign a pointer to the current tail
        Node currentTail = this.tail;

        // if the list is not empty
        if (currentTail != null) {
            // reset the pointers at the tail of the list:
            // set the current tail's next node to be the new tail
            currentTail.setNextNode(newTail);
            // set the new tail's previous node to the current tail
            newTail.setPreviousNode(currentTail);
        }
        // update the tail property to be the new tail
        this.tail = newTail;

        // if the list is empty, update the head property to be the new tail
        // since that node will be both the head and the tail
        if (this.head == null) {
            this.head = newTail;
        }
    }

    public String removeHead() {
        // since we will return the data contained in the removed head
        // assign a pointer to the removed head, that is, current head
        Node removedHead = this.head;

        // if current head is null, then the list is empty, so there is
        // nothing to return, return null, and the method ends
        if (removedHead == null) {
            return null;
        }
        // otherwise, update the list's head to be the current head's next node
        this.head = removedHead.getNextNode();

        // if the list had more than one element when we started,
        if (this.head != null) {
            // reassign this node's previous pointer to null to effectively
            // remove the former head node from the head of the list
            this.head.setPreviousNode(null);
        }

        // if there is only one element in the list, that is,
        // if the removed head was also the tail of the list
        if (removedHead == this.tail) {
            // call .removeTail() to make the necessary changes to the tail of the list
            this.removeTail();
        }

        return removedHead.data;
    }

    public String removeTail() {
        // since we will return the data contained in the removed tail
        // assign a pointer to the removed tail, that is, current tail
        Node removedTail = this.tail;

        // if current tail is null, then the list is empty, so there is
        // nothing to return, return null, and the method ends
        if (removedTail == null) {
            return null;
        }

        // otherwise, update the list's tail to be the current tail's previous node
        this.tail = removedTail.getPreviousNode();

        // if the list had more than one element when we started
        if (this.tail != null) {
            // reassign this node's next pointer to null to effectively
            // remove the former tail node from the tail of the list
            this.tail.setNextNode(null);
        }

        // if there is only one element in the list, that is,
        // if the removed tail was also the head of the list
        if (removedTail == this.head) {
            // call .removeHead() to make the necessary changes to the head of the list
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
