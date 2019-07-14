package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 10:08
 * @see <a href="https://leetcode.com/problems/merge-two-binary-trees/">617. Merge Two Binary Trees</a>
 */
public class MergeTwoBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    @Test
    public void test01() {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(3);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(5);

        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        tree2.right.right = new TreeNode(7);

        printTree(mergeTrees(tree1, tree2));
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}