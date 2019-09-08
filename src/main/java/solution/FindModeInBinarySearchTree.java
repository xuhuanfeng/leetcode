package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 9:19
 * @see <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/">501. Find Mode in Binary Search Tree</a>
 */
public class FindModeInBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> maps = new HashMap<>();

    public void doFind(TreeNode root) {
        if (root == null) {
            return;
        }

        int val = root.val;
        maps.put(val, maps.getOrDefault(val, 0) + 1);
        doFind(root.left);
        doFind(root.right);
    }

    public int[] findMode(TreeNode root) {
        doFind(root);
        int maxn = 0;
        for (Integer value : maps.values()) {
            if (value > maxn) {
                maxn = value;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() == maxn) {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        int idx = 0;
        for (Integer integer : list) {
            result[idx++] = integer;
        }
        return result;
    }
}
