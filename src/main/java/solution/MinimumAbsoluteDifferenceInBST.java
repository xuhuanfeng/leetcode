package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 8:58
 * @see <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">530. Minimum Absolute Difference in BST</a>
 */
public class MinimumAbsoluteDifferenceInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int minDiff = Integer.MAX_VALUE;

    public void doGetMinDiff(TreeNode root) {
        if (root == null) {
            return;
        }

        int diffLeftMost = Integer.MAX_VALUE;
        if (root.left != null) {
            TreeNode tmp = root.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            diffLeftMost = Math.abs(root.val - tmp.val);
        }

        int diffRightMost = Integer.MAX_VALUE;
        if (root.right != null) {
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            diffRightMost = Math.abs(root.val - tmp.val);
        }
        if (diffLeftMost < minDiff) {
            minDiff = diffLeftMost;
        }
        if (diffRightMost < minDiff) {
            minDiff = diffRightMost;
        }
        doGetMinDiff(root.left);
        doGetMinDiff(root.right);
    }

    TreeNode pre;

    // better one
    public void another(TreeNode root) {
        if (root == null) {
            return;
        }
        another(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - pre.val));
        }
        pre = root;
        another(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        // doGetMinDiff(root);
        another(root);
        return minDiff;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);

        assertEquals(2, getMinimumDifference(root));
    }
}
