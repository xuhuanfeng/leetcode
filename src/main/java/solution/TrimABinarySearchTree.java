package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 10:26
 * @see <a href="https://leetcode.com/problems/trim-a-binary-search-tree/">669. Trim a Binary Search Tree</a>
 */
public class TrimABinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int val = root.val;
        if (val >= L && val <= R) {
            root.left = trimBST(left, L, R);
            root.right = trimBST(right, L, R);
        } else if (val < L) {
            root = trimBST(right, L, R);
        } else {
            root = trimBST(left, L, R);
        }
        return root;
    }

    @Test
    public void test01() {
        TreeNode root;/*= new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root = trimBST(root, 1, 2);
        printTree(root);*/
        System.out.println("\n==========case=============");
        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root = trimBST(root, 1, 3);
        printTree(root);
        System.out.println();
        preOrder(root);
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
