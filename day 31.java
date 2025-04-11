//leetcode 203 remove linked list elements
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Handle the case where the head nodes contain 'val'
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Use two pointers to traverse the list
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val == val) {
                // Remove the current node
                prev.next = curr.next;
            } else {
                // Update 'prev' only when 'curr' is not removed
                prev = curr;
            }
            curr = curr.next;
        }

        return head; // Always return the modified list's head
    }
}

//leetcode 2 sum of nodes
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
