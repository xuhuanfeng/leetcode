package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-27 20:47
 * @see <a href="https://leetcode.com/problems/path-sum-iii/">437. Path Sum III</a>
 */
public class PathSumIII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 没有做出来，参考答案的
    // 这个题真是好题
    public int doFind(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + doFind(root.left, sum - root.val) + doFind(root.right, sum - root.val);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return doFind(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        assertEquals(3, pathSum(root, 8));
        System.out.println();

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        assertEquals(2, pathSum(root, 3));
    }
}
