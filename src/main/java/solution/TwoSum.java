package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-08-24 14:59
 * @see <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 */
public class TwoSum {
    class Node {
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        Arrays.sort(nodes, Comparator.comparingInt(n -> n.val));

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nodes[i].val + nodes[j].val;
            if (tmp == target) {
                return new int[]{Math.min(nodes[i].idx, nodes[j].idx), Math.max(nodes[i].idx, nodes[j].idx)};
            } else if (tmp < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }


    public int[] betterOne(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        return nums;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(betterOne(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(betterOne(new int[]{3, 2, 4}, 6)));
    }
}
