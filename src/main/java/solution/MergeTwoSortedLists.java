package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-08-07 20:55
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">21. Merge Two Sorted Lists</a>
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    tail = head;
                } else {
                    tail.next = l1;
                    tail = tail.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    tail = head;
                } else {
                    tail.next = l2;
                    tail = tail.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return head;
    }

    @Test
    public void test01() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode ll = mergeTwoLists(l1, l2);
        printList(ll);
    }

    private void printList(ListNode list) {
        while (list != null) {
            System.out.printf("%d ", list.val);
            list = list.next;
        }
        System.out.println();
    }
}
