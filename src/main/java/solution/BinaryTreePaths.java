package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-08-10 11:10
 * @see <a href="https://leetcode.com/problems/binary-tree-paths/">257. Binary Tree Paths</a>
 */
public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<String> result = new ArrayList<>();

    private void doCalc(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if (root.left != null) {
            doCalc(root.left, path + root.val + "->");
        }
        if (root.right != null) {
            doCalc(root.right, path + root.val + "->");
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        doCalc(root, "");
        return result;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
    }
}
