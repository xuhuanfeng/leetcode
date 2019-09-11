package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-11 20:02
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list/">234. Palindrome Linked List</a>
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private StringBuilder a = new StringBuilder();
    private StringBuilder b = new StringBuilder();

    public void doCalc(ListNode root) {
        if (root == null) {
            return;
        }
        a.append(root.val).append("+");
        doCalc(root.next);
        b.append(root.val).append("+");
    }

    public boolean isPalindrome(ListNode head) {
        doCalc(head);
        return a.toString().equals(b.toString());
    }

}
