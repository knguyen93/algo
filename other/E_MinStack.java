package other;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Constraints:
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 */
public class E_MinStack {
    class MNode {
        int min;
        int val;
        MNode next;

        MNode(int newVal, int newMin) {
            this.val = newVal;
            this.min = newMin;
        }
    }

    MNode head;

    /** initialize your data structure here. */
    public E_MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new MNode(x, x);
        } else {
            MNode newNode = new MNode(x, Math.min(x, head.min));
            newNode.next = head;
            head = newNode;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
