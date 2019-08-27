package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-27 20:00
 * @see <a href="https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/">671. Second Minimum Node In a Binary Tree</a>
 */
public class SecondMinimumNodeInABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int min, secondMin;

    public void doFind(TreeNode root) {
        if (root != null) {
            int t;
            if (root.left != null && root.right != null) {
                t = Math.min(root.left.val, root.right.val);
            } else {
                t = root.val;
            }
            if (t < min) {
                secondMin = min;
                min = t;
            } else if ((secondMin == -1 || t < secondMin) && t != min) {
                secondMin = t;
            }

            doFind(root.left);
            doFind(root.right);
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        secondMin = -1;

        doFind(root);
//        System.out.println("se " + secondMin + " min " + min);
        if (secondMin == min) {
            return -1;
        }
        return secondMin;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        assertEquals(-1, findSecondMinimumValue(root));
        System.out.println();

        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        assertEquals(5, findSecondMinimumValue(root));
        System.out.println();

        root = new TreeNode(5);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        assertEquals(6, findSecondMinimumValue(root));
    }
}
