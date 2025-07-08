package linkedlists;

// this class node is the object that contains the data and the reference to the next node
class Node {
    int data;
    Node next;

    // this constructor nets the object to the data and the next reference to null
    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedList {

    // the head is set to null when the linked list is first created
    Node head = null;

    // to add a node, we create a pointer node called current
    // current is the pointer we use to loop through the list
    // when we reach the end of the list, current.next == null
    public void add(int data) {
        Node newNode = new Node(data);
        Node current = head;

        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // use pointer node current to loop throught the list until current == null
    public void printValues() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    // simply make the new node point to the head
    // then make the head point to the new node
    // must first make the new node point to the head so we can "detach" the head
    // from its current place to the new ndoe
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // check if the list is empty or if the first value is the value to delete
    // use a current pointer node to loop through checking if the next value is the
    // value to delete
    // if the next node is the node we need to delete then we want to set the
    // current nodes next node to the node after the node we want to delete
    // if the node after is null, just set the current nodes next to null (case for
    // deleting the last item)
    public void delete(int data) {
        Node current = head;
        if (current != null) {
            if (current.data == data) {
                head = current.next;
            } else {
                while (current.next != null && current.next.data != data) {
                    current = current.next;
                }
                if (current.next != null) {
                    current.next = current.next.next;
                }
            }
        }
    }
}
