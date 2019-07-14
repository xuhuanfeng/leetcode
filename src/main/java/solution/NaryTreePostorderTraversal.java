package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 15:39
 * @see <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">590. N-ary Tree Postorder Traversal</a>
 */
public class NaryTreePostorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return result;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                postorder(child);
            }
        }
        result.add(root.val);
        return result;
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

        System.out.println(postorder(root));
    }
}
