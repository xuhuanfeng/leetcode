package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-09-23 20:50
 * @see <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/">1038. Binary Search Tree to Greater Sum Tree</a>
 */
public class BinarySearchTreeToGreaterSumTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int doSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = doSum(root.right);
        root.val += right;
        if (root.left != null) {
            root.left.val += root.val;
            doSum(root.left);
            return root.left.val;
        } else {
            return root.val;
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        int rightVAl = doSum(root.right);
        root.val += rightVAl;
        doSum(root.left);
        return root;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        printTree(bstToGst(root));
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.val);
        printTree(root.left);
        printTree(root.right);

    }
}
