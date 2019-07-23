package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-07-23 22:14
 * @see <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">637. Average of Levels in Binary Tree</a>
 */
public class AverageOfLevelsInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    List<Double> ans = new ArrayList<>();
    List<Integer> count = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) / count.get(i));
        }
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        int size = ans.size();
        if (level >= size) {
            ans.add(root.val * 1.0);
            count.add(1);
        } else {
            ans.set(level, ans.get(level) + root.val);
            count.set(level, count.get(level) + 1);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(averageOfLevels(root));
    }
}
