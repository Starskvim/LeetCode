import org.w3c.dom.Node;

public class SwapNodesInPairs {

    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode newHead = head.next;
        while (cur != null && cur.next != null) {
            ListNode mem = cur;
            cur = cur.next;

            mem.next = cur.next;
            cur.next = mem;

            cur = mem.next;
            if (cur != null && cur.next != null) {
                mem.next = cur.next;
            }
        }
        return newHead;
    }

    public class ListNode {
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

}
