//leetcode 61 rotate ll
//tc=O(n) sc-O(1)
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Calculate the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connect the tail to the head to form a circular list
        current.next = head;

        // Find the new head after rotation
        k = k % length; // Handle cases where k > length
        int stepsToNewHead = length - k;
        ListNode newTail = current;
        for (int i = 0; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Break the circular list to form the rotated list
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

//leetcode 138 random pointer
/*O(n) O(1)
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
  if(head==null){
            return null;
        }
        Node curr=head;
        while(curr!=null){
           Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Set the random pointers for the new nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original list and the copied list
        curr = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while (curr != null) {
            copy.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            copy = copy.next;
        }

        return dummy.next;

    }
