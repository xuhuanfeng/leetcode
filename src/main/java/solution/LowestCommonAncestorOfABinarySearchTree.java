package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-08-13 20:31
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">235. Lowest Common Ancestor of a Binary Search Tree</a>
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = doFind(root, p);
        List<TreeNode> list2 = doFind(root, q);
        int list1Index = list.size();
        int list2Index = list2.size();
        int min = Math.min(list1Index, list2Index);
        int index = 0;
        while (index < min) {
            TreeNode node1 = list.get(index);
            TreeNode node2 = list2.get(index);
            if (node1.val == node2.val && (index + 1) < min) {
                TreeNode node11 = list.get(index + 1);
                TreeNode node22 = list2.get(index + 1);
                if (node11.val != node22.val) {
                    return node1;
                }
            }
            index++;
        }
        return list.get(min - 1);
    }

    private List<TreeNode> doFind(TreeNode root, TreeNode p) {
        TreeNode tmp;
        List<TreeNode> list = new ArrayList<>();
        tmp = root;
        while (tmp != null && tmp.val != p.val) {
            list.add(tmp);
            if (tmp.val < p.val) {
                tmp = tmp.right;
            } else if (tmp.val > p.val) {
                tmp = tmp.left;
            }
        }
        list.add(tmp);
        return list;
    }

    public TreeNode betterOne(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal < parentVal && qVal < parentVal) {
            return betterOne(root.left, p, q);
        } else if (pVal > parentVal && qVal > parentVal) {
            return betterOne(root.right, p, q);
        } else {
            return root;
        }
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
        System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
        System.out.println(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(0)).val);
    }

    @Test
    public void test02() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(betterOne(root, new TreeNode(2), new TreeNode(8)).val);
        System.out.println(betterOne(root, new TreeNode(2), new TreeNode(4)).val);
        System.out.println(betterOne(root, new TreeNode(5), new TreeNode(0)).val);
    }
}
