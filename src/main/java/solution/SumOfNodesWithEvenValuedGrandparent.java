package solution;

/**
 * @author huanfeng.xu
 * @date 2020-03-02 19:12
 * @see <a href="https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/"></a>
 */
public class SumOfNodesWithEvenValuedGrandparent {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int val = 0;
    public void doCalc(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    val += root.left.left.val;
                }
                if (root.left.right != null) {
                    val += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    val += root.right.left.val;
                }
                if (root.right.right != null) {
                    val += root.right.right.val;
                }
            }
        }
        doCalc(root.left);
        doCalc(root.right);
    }

    public int sumEvenGrandparent(TreeNode root) {
        doCalc(root);
        return val;
    }
}
