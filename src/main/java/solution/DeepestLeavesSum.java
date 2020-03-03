package solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2020-03-03 20:07
 * @see <a href="https://leetcode.com/problems/deepest-leaves-sum/"></a>
 */
public class DeepestLeavesSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxDepth = -1;
    private int sum = 0;

    public void doFind(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (maxDepth < depth) {
            maxDepth = depth;
            sum = 0;
        }
        if (maxDepth == depth) {
            sum += root.val;
        }
        doFind(root.left, depth + 1);
        doFind(root.right, depth + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        doFind(root, 0);
        return sum;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        Assert.assertEquals(15, deepestLeavesSum(root));
    }
}
