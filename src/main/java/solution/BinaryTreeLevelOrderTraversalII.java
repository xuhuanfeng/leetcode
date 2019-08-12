package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-08-10 10:02
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">107. Binary Tree Level Order Traversal II</a>
 */
public class BinaryTreeLevelOrderTraversalII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void doCalculate(TreeNode root, List<List<Integer>> result, int index) {
        if (root == null) {
            return;
        }
        if (result.size() <= index) {
            result.add(index, new ArrayList<>());
        }
        result.get(index).add(root.val);
        doCalculate(root.left, result, index + 1);
        doCalculate(root.right, result, index + 1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        doCalculate(root, result, 0);
        for (int i = 0; i < result.size() / 2; i++) {
            List<Integer> list = result.get(i);
            List<Integer> list1 = result.get(result.size() - 1 - i);
            result.set(i, list1);
            result.set(result.size() - 1 - i, list);
        }
        return result;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(root));
    }
}
