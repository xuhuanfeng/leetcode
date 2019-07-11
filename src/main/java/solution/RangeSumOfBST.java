package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanfeng.xu
 * @date 2019-07-11 22:14
 * @see <a href="https://leetcode.com/problems/range-sum-of-bst/">938. Range Sum of BST</a>
 */
public class RangeSumOfBST {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }

        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    // 懒得去建树，直接提交了
}
