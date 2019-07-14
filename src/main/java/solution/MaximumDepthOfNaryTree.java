package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 22:17
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-n-ary-tree/">559. Maximum Depth of N-ary Tree</a>
 */
public class MaximumDepthOfNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int tMax = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                int tmp = maxDepth(child);
                tMax = Math.max(tMax, tmp);
            }
        }
        return tMax + 1;
    }

    @Test
    public void test01() {
        Node root = new Node();
        root.val = 1;
        Node left = new Node();
        left.val = 3;
        Node mid = new Node();
        mid.val = 2;
        Node right = new Node();
        right.val = 4;
        root.children = Arrays.asList(left, mid, right);
        left = new Node();
        left.val = 5;
        right = new Node();
        right.val = 6;
        root.children.get(0).children = Arrays.asList(left, right);

        assertEquals(3, maxDepth(root));

    }
}
