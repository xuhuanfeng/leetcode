package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-09-13 8:12
 * @see <a href="https://leetcode.com/problems/longest-univalue-path/">687. Longest Univalue Path</a>
 */
public class LongestUnivaluePath {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxn = Integer.MIN_VALUE;

    public int doFind(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            int left = doFind(root.left, target);
            int right = doFind(root.right, target);
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = doFind(root.left, root.val);
        int right = doFind(root.right, root.val);
        if (maxn < left + right) {
            maxn = left + right;
        }
        maxn = Math.max(longestUnivaluePath(root.left), maxn);
        maxn = Math.max(longestUnivaluePath(root.right), maxn);
        return maxn;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(longestUnivaluePath(root));
        maxn = Integer.MIN_VALUE;

        root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(root));
    }
}
