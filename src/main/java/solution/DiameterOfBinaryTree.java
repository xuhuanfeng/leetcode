package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-10 10:34
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">543. Diameter of Binary Tree</a>
 */
public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxLength = 0;

    public int doCalc(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = doCalc(root.left);
        int right = doCalc(root.right);
        int tmp = left + right + 1;
        if (tmp > maxLength) {
            maxLength = tmp;
        }
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        doCalc(root);
        return maxLength - 1 < 0 ? 0 : maxLength - 1;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        assertEquals(3, diameterOfBinaryTree(root));
    }
}
