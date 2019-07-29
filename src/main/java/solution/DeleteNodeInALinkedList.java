package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-07-29 14:15
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">237. Delete Node in a Linked List</a>
 */
public class DeleteNodeInALinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null) {
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }

    @Test
    public void test01() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node.next.next.next.next = node1;
        deleteNode(node1);

        while (node != null) {
            System.out.printf("%d ", node.val);
            node = node.next;
        }
    }
}
