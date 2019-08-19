package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-08-18 10:36
 * @see
 */
public class MaximumLevelSumOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public void doCalc(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        Integer levelSum = map.getOrDefault(level, 0);
        levelSum += root.val;
        map.put(level, levelSum);
        doCalc(root.left, level + 1);
        doCalc(root.right, level + 1);
    }

    public int maxLevelSum(TreeNode root) {
        doCalc(root, 1);
        int maxVal = Integer.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            if (value > maxVal) {
                maxVal = value;
                minLevel = key;
            } else if (value == maxVal) {
                if (minLevel > key) {
                   minLevel = key;
                }
            }
        }
        return minLevel;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right = new TreeNode(0);
        System.out.println(maxLevelSum(root));
    }
}
