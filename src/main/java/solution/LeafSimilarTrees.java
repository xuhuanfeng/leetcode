package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-07-20 22:14
 * @see <a href="https://leetcode.com/problems/leaf-similar-trees/">872. Leaf-Similar Trees</a>
 */
public class LeafSimilarTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void getLeaf(TreeNode root, List<Integer> leaf) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        getLeaf(root.left, leaf);
        getLeaf(root.right, leaf);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafOne = new ArrayList<>();
        List<Integer> leafTwo = new ArrayList<>();
        getLeaf(root1, leafOne);
        getLeaf(root2, leafTwo);
        return leafOne.equals(leafTwo);
    }
}
