package solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-24 22:04
 * @see <a href="https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/">1022. Sum of Root To Leaf Binary Numbers</a>
 */
public class SumOfRootToLeafBinaryNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        return doCalcPath(root, "");
    }

    private int doCalcPath(TreeNode root, String str) {
        if (root == null) {
            // System.out.println("null: " + str);
            return 0;
        }
        if (root.left == null && root.right == null) {
            // System.out.println(str);
            return Integer.parseInt(str + root.val, 2);
        }
        return doCalcPath(root.left, str + root.val) + doCalcPath(root.right, str + root.val);
    }

    // better solution

    int ans = 0;

    public int another(TreeNode root) {
        calc(root, 0);
        return ans;
    }

    private void calc(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        val = val << 1 | root.val;
        if (root.left == null && root.right == null) {
            ans += val;
        }
        calc(root.left, val);
        calc(root.right, val);
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        assertEquals(22, sumRootToLeaf(root));
        assertEquals(22, another(root));

    }
}
