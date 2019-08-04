package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 14:18
 * @see <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">783. Minimum Distance Between BST Nodes</a>
 */
public class MinimumDistanceBetweenBSTNodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int min = Integer.MAX_VALUE;
    TreeNode pre;

    public void doCalcMinDiff(TreeNode root) {
        if (root == null) {
            return;
        }
        doCalcMinDiff(root.left);
        if (pre != null) {
            int tmp = root.val - pre.val;
            if (min > tmp) {
                min = tmp;
            }
        }
        pre = root;
        doCalcMinDiff(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        pre = null;
        doCalcMinDiff(root);
        return min;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        assertEquals(1, minDiffInBST(root));
    }
}
