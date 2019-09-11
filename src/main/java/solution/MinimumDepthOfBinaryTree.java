package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-11 20:53
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">111. Minimum Depth of Binary Tree</a>
 */
public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int minDepth = Integer.MAX_VALUE;

    private void doFind(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth < minDepth) {
                minDepth = depth;
            }
        }
        doFind(root.left, depth + 1);
        doFind(root.right, depth + 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doFind(root, 1);
        return minDepth;
    }
}
