package solution;

/**
 * @author huanfeng.xu
 * @date 2020-03-04 19:26
 * @see <a href="https://leetcode.com/problems/insert-into-a-binary-search-tree/"></a>
 */
public class InsertintoABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode oldRoot = root;

        while (true) {
            if (root.val > val) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new TreeNode(val);
                    return oldRoot;
                }
            } else if (root.val < val) {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new TreeNode(val);
                    return oldRoot;
                }
            }
        }
    }
}
