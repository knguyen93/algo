package linked_list;

/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * E.g: 
 * Input: 1->2->3->4->5->NULL 
 * Output: 1->3->5->2->4->NULL
 */
public class SingleOddEven {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head, even = head.next, headEven = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // move 2 step each
            even.next = even.next.next;
            odd = odd.next; // update current odd & even
            even = even.next;
        }

        odd.next = headEven; // join the results
        return head;
    }
}