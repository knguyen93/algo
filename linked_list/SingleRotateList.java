package linked_list;

/**
 * Leetcode:
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * 
 * E.g:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * -    rotate 1 steps to the right: 5->1->2->3->4->NULL
 * -    rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * -    rotate 1 steps to the right: 2->0->1->NULL
 * -    rotate 2 steps to the right: 1->2->0->NULL
 * -    rotate 3 steps to the right: 0->1->2->NULL
 * -    rotate 4 steps to the right: 2->0->1->NULL
 */
public class SingleRotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
          return head;
        }
      
        ListNode cursor = head; int count = 1;      
        while (cursor.next != null) {
          cursor = cursor.next;
          count++;
        }
      
        int steps = k <= count ? count - k : (k % count) > 0 ? count - (k % count) : 0;
        if (steps > 0) {
          // get the tail after steps
          ListNode newHead; cursor = head; int i = 1;
          while (i < steps) {
            cursor = cursor.next;
            i++;
          }
          
          newHead = cursor.next;
          cursor.next = null;
          
          // connect newHead to old head
          cursor = newHead;
          while (cursor.next != null) {
            cursor = cursor.next;
          }
          
          cursor.next = head;
          head = newHead;
        }
      
        return head;
    }
}