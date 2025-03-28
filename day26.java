//gfg doubly linked list insertion at given position
public class LinkedList {
    Node head; // Pointer to the head of the list

    // Definition of a singly linked list node
    class Node {
        int data;
        Node next;

        Node(int data) { // Constructor
            this.data = data;
            this.next = null;
        }
    }

    // Method to insert a node at a given position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data); // Create a new node

        if (position == 1) { // If the position is at the head
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currNode = head; // Start traversal from the head
        int count = 1; // Position counter

        while (currNode != null && count < position - 1) { // Traverse to the node before the desired position
            currNode = currNode.next;
            count++;
        }

        if (currNode == null) { // If the position is out of bounds
            System.out.println("Invalid position!");
            return;
        }

        newNode.next = currNode.next; // Point the new node to the next node
        currNode.next = newNode; // Point the current node to the new node
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPosition(10, 1); // Insert 10 at position 1
        list.insertAtPosition(20, 2); // Insert 20 at position 2
        list.insertAtPosition(15, 2); // Insert 15 at position 2
        list.insertAtPosition(5, 1);  // Insert 5 at position 1
        list.printList(); // Print the list
    }
}

//gfg insert node
public class LinkedList {
    Node head; // Pointer to the head of the list

    // Definition of a singly linked list node
    class Node {
        int data;
        Node next;

        Node(int data) { // Constructor
            this.data = data;
            this.next = null;
        }
    }

    // Method to search for a value in the list
    public boolean search(int target) {
        Node currNode = head; // Start from the head
        while (currNode != null) { // Traverse the list
            if (currNode.data == target) { // Check if the current node's data matches the target
                return true; // Value found
            }
            currNode = currNode.next; // Move to the next node
        }
        return false; // Value not found
    }

    // Method to add a node at the end
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtEnd(10); // Add nodes
        list.addAtEnd(20);
        list.addAtEnd(30);

        System.out.println("List: ");
        list.printList(); // Print the list

        int target = 20; // Value to search
        if (list.search(target)) {
            System.out.println(target + " is found in the list.");
        } else {
            System.out.println(target + " is not found in the list.");
        }
    }
}
