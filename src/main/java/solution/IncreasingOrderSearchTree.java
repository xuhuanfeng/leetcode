package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-07-15 21:02
 * @see <a href="https://leetcode.com/problems/increasing-order-search-tree/">897. Increasing Order Search Tree</a>
 */
public class IncreasingOrderSearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> values = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        init(root);
        return buildTree(0);
    }

    private TreeNode buildTree(int index) {
        if (index < values.size()) {
            TreeNode root = new TreeNode(values.get(index));
            root.right = buildTree(++index);
            return root;
        }
        return null;
    }

    private void init(TreeNode root) {
        if (root == null) {
            return;
        }
        init(root.left);
        values.add(root.val);
        init(root.right);
    }

    private TreeNode head, pre;

    public TreeNode another(TreeNode root) {
        if (root == null) {
            return null;
        }
        another(root.left);
        if (pre != null) {
            root.left = null;
            pre.right = root;
        }
        if (head == null) {
            head = root;
        }
        pre = root;
        another(root.right);
        return head;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        // root = increasingBST(root);
        root = another(root);
        printTree(root);
    }

    private void printTree(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
