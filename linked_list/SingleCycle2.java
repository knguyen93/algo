package linked_list;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null. To represent a cycle in the given linked list, we use an
 * integer pos which represents the position (0-indexed) in the linked list
 * where tail connects to. If pos is -1, then there is no cycle in the linked
 * list. Note: Do not modify the linked list
 */
public class SingleCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head, result;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // walk 1 step faster on every walk

            if (slow == fast) { //found the cycle
                result = head;

                while (result != slow) { // find where first cycle start
                    result = result.next;
                    slow = slow.next;
                }

                return result;
            }
        }

        return null;
    }

    /**
     * Test
     * 
     * Input: head = [3,2,0,-4], pos = 1
     * Output: tail connects to node index 1
     * 
     * Input: head = [1,2], pos = 0
     * Output: tail connects to node index 0
     */
}