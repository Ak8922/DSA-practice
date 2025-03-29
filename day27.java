//reverse doubly LL
//O(n) O(1)
 public Node revLL() {
        if (head == null || head.next == null) { // Base case: empty or single-node list
            return head;
        }
        
        Node curr = head;
        Node temp = null;
    
        // Swap prev and next pointers for each node
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev; // Move to the next node (which is now prev due to swapping)
        }
        
        // Update head to the new head of the reversed list
        if (temp != null) {
            head = temp.prev; // The previous of last node becomes the new head
        }
        return head;
    }


//delete node at a given postion
public void deleteNodeAtPosition(int position) {
    if (head == null || position < 1) { // Check if the list is empty or position is invalid
        System.out.println("Invalid position or empty list.");
        return;
    }

    Node temp = head; // Start from the head
    int count = 1;

    // Traverse to the node at the specified position
    while (count < position && temp != null) {
        temp = temp.next;
        count++;
    }

    if (temp == null) { // If position is out of bounds
        System.out.println("Position out of bounds.");
        return;
    }

    // Unlink the node from the list
    if (temp.prev != null) {
        temp.prev.next = temp.next;
    } else { // If deleting the head node
        head = temp.next;
    }

    if (temp.next != null) {
        temp.next.prev = temp.prev;
    }

    System.out.println("Node at position " + position + " deleted.");
}
     
