package linked_list;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * E.g:
 * 
 * Input: 1->2 Output: false
 */
public class SinglePalindrome {
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode cursor = head;
        while (cursor != null) {
            count++;
            cursor = cursor.next;
        }

        if (count == 0)
            return true;

        ListNode temp, newNext = null;
        cursor = head;
        
        for (int i = 0; i < count; i++) {
            if (i < count / 2) { // reverse the first half
                temp = cursor;
                cursor = cursor.next;
                temp.next = newNext;
                newNext = temp;
            } else if ((count % 2) > 0 && i < (count / 2) + 1) {
                cursor = cursor.next; // skip the middle item if there is
            } else { // compare the reversed list with the second half
                if (newNext.val != cursor.val)
                    return false;

                cursor = cursor.next;
                newNext = newNext.next;
            }
        }

        return true;
    }
}