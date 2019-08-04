package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 21:45
 * @see <a href="https://leetcode.com/problems/convert-bst-to-greater-tree/">538. Convert BST to Greater Tree</a>
 */
public class ConvertBSTToGreaterTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode pre = null;

    public void doConvert(TreeNode root) {
        if (root == null) {
            return;
        }

        doConvert(root.right);
        if (pre != null) {
            root.val += pre.val;
        }
        pre = root;
        doConvert(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        pre = null;
        doConvert(root);
        return root;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        root = convertBST(root);

        printTree(root);
        System.out.println();
        root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(3);
        root = convertBST(root);

        printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
