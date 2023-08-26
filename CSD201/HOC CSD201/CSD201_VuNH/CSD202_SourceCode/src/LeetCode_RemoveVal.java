
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        if (p == null) {
            return head;
        }
        while (p.next != null) {
            /*...0*/ /*0123...n-1 n null*/
            if (p.next.val == val) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        if (head.val == val) {
            head = head.next;
        }

        return null;
    }
}
