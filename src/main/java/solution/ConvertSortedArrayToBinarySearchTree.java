package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 10:21
 * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">108. Convert Sorted Array to Binary Search Tree</a>
 */
public class ConvertSortedArrayToBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode buildTree(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(left, mid - 1, nums);
        root.right = buildTree(mid + 1, right, nums);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }

    @Test
    public void test01() {
        TreeNode root = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
