package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-11 20:31
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/">203. Remove Linked List Elements</a>
 */
public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next != null && tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }


}
