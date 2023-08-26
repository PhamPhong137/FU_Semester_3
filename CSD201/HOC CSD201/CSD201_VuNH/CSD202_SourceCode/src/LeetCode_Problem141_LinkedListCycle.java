
import java.util.HashSet;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class LeetCode_Problem141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        HashSet<ListNode> s = new HashSet<ListNode>();
        while (p != null) {
            if (s.contains(p)) {
                return true;
            }
            s.add(p);
            p = p.next;

        }
        return false;
    }

}
