package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-02 20:31
 * @see <a href="https://leetcode.com/problems/subtree-of-another-tree/">572. Subtree of Another Tree</a>
 */
public class SubtreeOfAnotherTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean doFind(TreeNode s, TreeNode t) {
        if (s != null && t != null && s.val == t.val) {
            return doFind(s.left, t.left) && doFind(s.right, t.right);
        }
        return s == null && t == null;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            if (doFind(s, t)) {
                return true;
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return s == null && t == null;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        assertTrue(isSubtree(root, t));
    }
}
