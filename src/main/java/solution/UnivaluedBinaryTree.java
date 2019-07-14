package solution;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 16:24
 * @see <a href="https://leetcode.com/problems/univalued-binary-tree/">965. Univalued Binary Tree</a>
 */
public class UnivaluedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null && root.val != left.val) {
            return false;
        }
        if (right != null && root.val != right.val) {
            return false;
        }
        return isUnivalTree(left) && isUnivalTree(right);
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        assertTrue(isUnivalTree(root));

        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        assertFalse(isUnivalTree(root));
    }
}
