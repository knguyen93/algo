package linked_list;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * NOTES: You may assume the two numbers do not contain any leading zero, except
 * the number 0 itself.
 * 
 * E.g: 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 * Output: 7 -> 0 -> 8 
 * Explanation: 342 + 465 = 807.
 */
public class SingleAddTwoBigNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int total = 0, nextVal = 0;
        ListNode result = null, cursor = null;
        while (l1 != null || l2 != null) {
            total += nextVal;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            nextVal = total >= 10 ? total / 10 : 0; // reset nextVal
            if (cursor == null) {
                cursor = new ListNode(total % 10);
                result = cursor;
            } else {
                cursor.next = new ListNode(total % 10); // assign new Node
                cursor = cursor.next; // move forward
            }
            total = 0;
        }

        // last round
        if (nextVal > 0) {
            cursor.next = new ListNode(nextVal);
        }

        return result;
    }
}