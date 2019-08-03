package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 10:12
 * @see <a href="https://leetcode.com/problems/construct-string-from-binary-tree/">606. Construct String from Binary Tree</a>
 */
public class ConstructStringFromBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void doOps(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        builder.append(root.val);
        if (root.left != null) {
            builder.append("(");
            doOps(root.left, builder);
            builder.append(")");
        } else {
            if (root.right != null) {
                builder.append("()");
            }
        }
        if (root.right != null) {
            builder.append("(");
            doOps(root.right, builder);
            builder.append(")");
        }
    }

    public String tree2str(TreeNode t) {
        StringBuilder builder = new StringBuilder();
        doOps(t, builder);
        return builder.toString();
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        assertEquals("1(2(4))(3)", tree2str(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        assertEquals("1(2()(4))(3)", tree2str(root));
    }
}
