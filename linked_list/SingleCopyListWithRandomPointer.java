package linked_list;

/**
 * Leetcode: Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null. Return a deep copy
 * of the list. The Linked List is represented in the input/output as a list of
 * n nodes. Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) where random pointer points to, or null if it does not
 * point to any node.
 */
class SingleCopyListWithRandomPointer {

    /**
     * Copy Strategy: modify original list and then revert
     * 
     * A => B => C
     * A => A' => B => B' => C => C'
     */
    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // add dummy head
        Node newHead = new Node(0), newCursor = newHead, temp = null;

        // make copies of original nodes as NEXT
        Node cursor = head;
        while (cursor != null) {
            temp = cursor.next;
            cursor.next = new Node(cursor.val);
            cursor.next.next = temp;
            cursor = cursor.next.next;
        }

        // init random nodes
        cursor = head;
        while (cursor != null) {
            if (cursor.random != null) {
                cursor.next.random = cursor.random.next;
            }

            // move
            cursor = cursor.next.next;
        }

        // un-link copied nodes from original list
        cursor = head;
        while (cursor != null) {
            newCursor.next = cursor.next;
            cursor.next = cursor.next.next;
            cursor = cursor.next;
            newCursor = newCursor.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        Node c = head;
        while (c != null) {
            System.out.print(c + " ");
            System.out.print(" [" + c.random + "] => ");
            c = c.next;
        }

        System.out.println("\nAfter");
        Node newHead = copyRandomList(head);
        Node curr = newHead;
        while (curr != null) {
            System.out.print(curr + " ");
            System.out.print(" [" + curr.random + "] => ");
            curr = curr.next;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        @Override
        public String toString() {
            return String.valueOf(val);
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}