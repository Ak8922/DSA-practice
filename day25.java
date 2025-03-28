//gfg insertion at end
Node head; // Linked list head pointer

    public class Node {
        int data;
        Node next;

        Node(int data) { // Constructor to initialize a node with data
            this.data = data;
            this.next = null;
        }
    }
 public void addLast(int data) { 
        Node newNode = new Node(data); // Pass 'data' to the constructor
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

public void PrintLL() { // Print linked list
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }


//leetcode 237 delete node
class  Solution {
    public void deleteNode(ListNode node) {
         node.val = node.next.val;
        
        // Skip the next node
        node.next = node.next.next;
    }}
