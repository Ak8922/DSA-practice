//leetocde 82 remove duplicates
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // Pointer to track the node before duplicates

        while (head != null) {
            // Check if the current node is a duplicate
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to the node after duplicates
                prev.next = head.next;
            } else {
                // Move prev forward if no duplicate is found
                prev = prev.next;
            }
            head = head.next; // Move head forward
        }

        return dummy.next; // Return the modified list
    }
}

//leetcode 25 reverse nodes in k group
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy, next = dummy;

        // Count the number of nodes in the list
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Reverse nodes in groups of k
        while (count >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}
