package linked_list;

/**
 * Reverse a singly linked list.
 */
public class SingleReverse {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        return reverse(head, null);
    }

    /**
     * Iterative
     */
    private ListNode reverseListIterative(ListNode head) {
        if (head == null) return head;
        ListNode cursor = head, newNext = null, temp; // 1 => 2 => 3
        while (cursor != null) {
          temp = cursor;
          cursor = cursor.next; // move one step
          temp.next = newNext;
          newNext = temp; // update new Next
        }
      
        return newNext;
    }

    /**
     * Recursive
     */
    private ListNode reverse(ListNode curr, ListNode prev) {
        if (curr.next == null) { // end of list
            curr.next = prev; // link prev node to current next
            return curr;
        }
        
        ListNode nex = curr.next; // keep current next for next round
        curr.next = prev; // link current next to prev
        return reverse(nex, curr);
    }
}