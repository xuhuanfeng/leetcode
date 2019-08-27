package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-08-27 19:52
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">83. Remove Duplicates from Sorted List</a>
 */
public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = head;
        while (t != null) {
            ListNode next = t.next;
            if (next != null && t.val == next.val) {
                t.next = t.next.next;
            } else {
                t = t.next;
            }
        }
        return head;
    }

    @Test
    public void test01() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head = deleteDuplicates(head);
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();

        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        head = deleteDuplicates(head);
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        head = deleteDuplicates(head);
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
    }
}
