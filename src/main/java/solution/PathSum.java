package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 10:25
 * @see <a href="https://leetcode.com/problems/path-sum/">112. Path Sum</a>
 */
public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 懒得去建树了
    public boolean doFind(TreeNode root, int sum, int parentSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (root.val + parentSum == sum) {
                return true;
            }
        }
        return doFind(root.left, sum, parentSum + root.val)
                || doFind(root.right, sum, parentSum + root.val);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return doFind(root, sum, 0);
    }
}
