package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 11:14
 * @see <a href="https://leetcode.com/problems/n-ary-tree-level-order-traversal/">429. N-ary Tree Level Order Traversal</a>
 */
public class NaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Node>> queue = new LinkedList<>();
        List<Integer> vals = Collections.singletonList(root.val);
        queue.offer(Collections.singletonList(root));
        result.add(vals);
        while (!queue.isEmpty()) {
            List<Node> nodes = queue.poll();
            List<Node> childNode = new ArrayList<>();
            for (Node node : nodes) {
                if (node != null) {
                    if (node.children != null) {
                        childNode.addAll(node.children);
                    }
                }
            }

            if (childNode.size() > 0) {
                List<Integer> temp = new ArrayList<>();
                for (Node node : childNode) {
                    temp.add(node.val);
                }
                result.add(temp);
                queue.offer(childNode);
            }
        }
        return result;
    }

    public List<List<Integer>> another(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while (!nodeList.isEmpty()) {
            int len = nodeList.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = nodeList.poll();
                if (node != null) {
                    temp.add(node.val);
                    if (node.children != null) {
                        for (Node child : node.children) {
                            nodeList.offer(child);
                        }
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }

    @Test
    public void test01() {
        Node root = new Node();
        root.val = 1;
        List<Node> child = new ArrayList<>();
        Node left = new Node();
        Node mid = new Node();
        Node right = new Node();
        left.val = 3;
        mid.val = 2;
        right.val = 4;
        child.add(left);
        child.add(mid);
        child.add(right);
        left.children = Arrays.asList(new Node(5, null), new Node(6, null));
        root.children = child;
        // System.out.println(levelOrder(root));
        System.out.println(another(root));
    }
}
