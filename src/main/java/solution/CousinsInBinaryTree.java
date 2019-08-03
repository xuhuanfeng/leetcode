package solution;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 9:50
 * @see <a href="https://leetcode.com/problems/cousins-in-binary-tree/">993. Cousins in Binary Tree</a>
 */
public class CousinsInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Node {
        int val;
        int depth;
        TreeNode parent;

        public Node(int val, int depth, TreeNode parent) {
            this.val = val;
            this.depth = depth;
            this.parent = parent;
        }
    }

    private Node find(TreeNode root, int depth, int target) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.left.val == target) {
            return new Node(target, depth + 1, root);
        } else if (root.right != null && root.right.val == target) {
            return new Node(target, depth + 1, root);
        } else {
            Node node = find(root.left, depth + 1, target);
            if (node == null) {
                node = find(root.right, depth + 1, target);
            }
            return node;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Node xNode = find(root, 0, x);
        Node yNode = find(root, 0, y);
        if (xNode == null || yNode == null) {
            return false;
        }
        return xNode.depth == yNode.depth && xNode.parent != yNode.parent;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        assertFalse(isCousins(root, 4, 3));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        assertTrue(isCousins(root, 5, 4));
    }
}
