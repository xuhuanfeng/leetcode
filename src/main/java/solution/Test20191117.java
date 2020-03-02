package solution;

import org.junit.Test;

import java.util.*;

public class Test20191117 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }
        int n = grid.length;
        int m = grid[0].length;
        int len = n * m;

        k = k % (len);

        int[] helper = new int[n * m];
        int idx = k - 1;
        for (int i = len - 1; i > (len - 1 - k); i--) {
            helper[idx--] = grid[i / n][i % m];
        }
        idx = k;
        for (int i = 0; i <= (len - 1 - k); i++) {
            helper[idx++] = grid[i / n][i % m];
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < helper.length; i++) {
            if (i % m == 0) {
                t = new ArrayList<>();
                result.add(t);
            }
            t.add(helper[i]);
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class FindElements {

        Set<Integer> nodeVal = new HashSet<>();

        private void buildTree(TreeNode old, int parentVal) {
            if (old == null) {
                return;
            }
            if (old.left != null) {
                nodeVal.add(parentVal * 2 + 1);
                buildTree(old.left, parentVal * 2 + 1);
            }
            if (old.right != null) {
                // newTree.right = new TreeNode(newTree.val * 2 + 2);
                nodeVal.add(parentVal * 2 + 2);
                buildTree(old.right, parentVal * 2 + 2);
            }
        }

        public FindElements(TreeNode root) {
            buildTree(root, 0);
        }

        public boolean find(int target) {
            return nodeVal.contains(target);
        }
    }

    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> one = new LinkedList<>();
        LinkedList<Integer> two = new LinkedList<>();
        int sum = 0;
        for (int num : nums) {
            int tmp = num % 3;
            sum += num;
            if (tmp % 3 == 1) {
                one.add(num);
            } else if (tmp % 3 == 2){
                two.add(num);
            }
        }

        int oneLen = one.size();
        int twoLen = two.size();
        int oneLeft = oneLen % 3;
        int twoLeft = twoLen % 3;
        if (oneLeft == twoLeft) {
            return sum;
        }

        if (oneLeft - twoLeft == 1) {
            if (twoLen <= 1) {
                return sum - one.get(0);
            }
            return sum - Math.min(one.get(0), two.get(0) + two.get(1));
        }
        if (oneLeft - twoLeft == 2) {
            if (twoLen == 0) {
                return sum - one.get(0) - one.get(1);
            }
            return sum - Math.min(one.get(0) + one.get(1), two.get(0));
        }
        if (oneLeft - twoLeft == -1) {
            if (oneLen <= 1) {
                return sum - two.get(0);
            }
            return sum - Math.min(two.get(0), one.get(0) + one.get(1));
        }
        if (oneLeft - twoLeft == -2) {
            if (oneLen == 0) {
                return sum - two.get(0) - two.get(1);
            }
            return sum - Math.min(two.get(0) + two.get(1), one.get(0));
        }

        return sum;
    }

    @Test
    public void test01() {
        System.out.println(shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
        System.out.println(shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9));
        System.out.println(shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4));
    }

    @Test
    public void test02() {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        FindElements findElements = new FindElements(root);
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(2));

        root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(-1);
        root.right.left.left = new TreeNode(-1);
        findElements = new FindElements(root);
        System.out.println(findElements.find(2));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(4));
        System.out.println(findElements.find(5));
    }

    @Test
    public void test03() {
        /*System.out.println(maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
        System.out.println(maxSumDivThree(new int[]{5, 2, 2, 2}));*/
        System.out.println(maxSumDivThree(new int[]{2, 19, 6, 16, 5, 10, 7, 4, 11, 6}));
        System.out.println(maxSumDivThree(new int[]{366, 809, 6, 792, 822, 181, 210, 588, 344, 618, 341, 410, 121, 864, 191, 749, 637, 169, 123, 472, 358, 908, 235, 914, 322, 946, 738, 754, 908, 272, 267, 326, 587, 267, 803, 281, 586, 707, 94, 627, 724, 469, 568, 57, 103, 984, 787, 552, 14, 545, 866, 494, 263, 157, 479, 823, 835, 100, 495, 773, 729, 921, 348, 871, 91, 386, 183, 979, 716, 806, 639, 290, 612, 322, 289, 910, 484, 300, 195, 546, 499, 213, 8, 623, 490, 473, 603, 721, 793, 418, 551, 331, 598, 670, 960, 483, 154, 317, 834, 352}));
    }
}
