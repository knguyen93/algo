package linked_list;

class SingleLinkedList {
    /** Initialize your data structure here. */
    ListNode head;
    int size;
    
    public SingleLinkedList() {
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size == 0 || index > size - 1) {
            return -1;
        }
        
        ListNode result = head;
        for (int i=1; i <= index; i++) {
            result = result.next;
        }
        
        return result.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        
        if (size == 0) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        
        if (size == 0) {
            head = newNode;
        } else {
            ListNode current = head;
            while(current.next != null) {
                current = current.next;
            }
            
            current.next = newNode;
        }
        
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        
        if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
            size++;
        }  else {
            ListNode newNode = new ListNode(val);
            ListNode result = head;
            ListNode next = result.next;
            for (int i=1; i < index; i++) {
                result = next;
                next = next.next;
            }

            newNode.next = next;
            result.next = newNode;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size > 0 && index < size)  {
            if (index == 0) {
                // remove head
                ListNode next = head.next;
                head = next;
                size--;
                return;
            }
            
            ListNode current = head;
            ListNode next = head.next;
            int idx = 0;
            
            while (idx < index - 1) {
                current = next;
                next = next.next; // move forward
                idx++;
            }
            
            current.next = next.next;
            size--;
        }
    }
}