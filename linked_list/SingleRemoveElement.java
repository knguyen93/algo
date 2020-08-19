package linked_list;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * E.g: Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 */
public class SingleRemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            // remove head
            head = head.next;
        }

        ListNode cursor = head;
        while (cursor != null && cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }

        return head;
    }
}