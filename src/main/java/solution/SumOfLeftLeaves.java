package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 15:39
 * @see <a href="https://leetcode.com/problems/sum-of-left-leaves/">404. Sum of Left Leaves</a>
 */
public class SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int doSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int leftVal = doSum(root.left);
        sum += leftVal;
        doSum(root.right);
        return 0;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        doSum(root);
        return sum;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(24, sumOfLeftLeaves(root));
    }
}
