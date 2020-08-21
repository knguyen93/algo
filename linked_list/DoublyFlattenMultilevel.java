package linked_list;

/**
 * Flatten a Multilevel Doubly Linked List
 * 
 * You are given a doubly linked list which in addition to the next and previous
 * pointers, it could have a child pointer, which may or may not point to a
 * separate doubly linked list. These child lists may have one or more children
 * of their own, and so on, to produce a multilevel data structure, as shown in
 * the example below. Flatten the list so that all the nodes appear in a
 * single-level, doubly linked list. You are given the head of the first level
 * of the list.
 * 
 * E.g:
 * 
 * Input: 
 * 
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 */
public class DoublyFlattenMultilevel {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node cursor = head;
        // find node has child
        while (cursor != null && cursor.child == null) {
            cursor = cursor.next;
        }

        // handle node has child
        if (cursor != null) {
            // link tail of child Node
            if (cursor.next != null) {
                Node tail = cursor.child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = cursor.next;
                cursor.next.prev = tail;
            }

            Node newNode = flatten(cursor.child);
            cursor.child = null; // make sure we cleanup the mess

            // link newNode head
            cursor.next = newNode;
            newNode.prev = cursor;
        }

        return head;
    }

     /**
     * I also found a good helper solution at
     * https://thefellowprogrammer.blogspot.com/2020/07/flatten-multilevel-doubly-linked-list.html
     */

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}