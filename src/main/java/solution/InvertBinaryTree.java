package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-07-23 22:57
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">226. Invert Binary Tree</a>
 */
public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = right;
        return root;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root = invertTree(root);
        printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
