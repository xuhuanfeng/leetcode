package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 20:14
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>
 */
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = null;
        while (newHead != null) {
            ListNode tmp = newHead.next;
            newHead.next = head;
            head = newHead;
            newHead = tmp;
        }
        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%s ", head.val);
            head = head.next;
        }
    }

    @Test
    public void test01() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseList(head);
        printList(listNode);
    }
}
