package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static void printNode(ListNode head) {
        ListNode cursor = head;
        List<String> vals = new ArrayList<String>();
        while(cursor != null) {
            vals.add(cursor.toString());
        }

        System.out.println(vals.stream().collect(Collectors.joining(",")));
    }
}