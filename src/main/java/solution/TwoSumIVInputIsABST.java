package solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-01 20:46
 * @see <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">653. Two Sum IV - Input is a BST</a>
 */
public class TwoSumIVInputIsABST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 可以直接采用集合的形式，将每次遍历的值放到集合中
    // 就不用每次都从头遍历一次树了，从O(n) -> O(1)
    public boolean doFind(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            return true;
        } else if (root.val < k) {
            return doFind(root.right, k);
        } else {
            return doFind(root.left, k);
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            int tmp = k - head.val;
            if (tmp != head.val && doFind(root, tmp)) {
                return true;
            }
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
        return false;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        assertTrue(findTarget(root, 8));

        assertFalse(findTarget(root, 28));
    }
}
