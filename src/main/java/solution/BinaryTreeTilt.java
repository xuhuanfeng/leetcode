package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-10 10:42
 * @see <a href="https://leetcode.com/problems/binary-tree-tilt/">563. Binary Tree Tilt</a>
 */
public class BinaryTreeTilt {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = 0;

    public int doCalc(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = doCalc(root.left);
        int right = doCalc(root.right);
        ans += Math.abs(left - right);
        return root.val + left + right;
    }

    public int findTilt(TreeNode root) {
        doCalc(root);
        return ans;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(1, findTilt(root));
    }
}
