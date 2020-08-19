package linked_list;

public class SingleRemoveNthFromEndOfList {
    /**Given a linked list, remove the n-th node from the end of list and return its head.
     * 
     * E.G:
     * 
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * 
     * Notes: Given n will always be valid.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {      
        ListNode first = head, second = head;
        for (int i = 0; i < n; i++) {
          second = second.next; // walk faster than n-steps
        }
        
        while (second != null && second.next != null) {// walk to the end
          first = first.next;
          second = second.next;
        }
        
        if (first == head && second == null) {
          // remove head
          head = head.next;
        } else {
          // remove next
          first.next = first.next.next;
        }
        return head;
      }
}