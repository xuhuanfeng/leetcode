package solution;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-17 20:17
 * @see <a href="https://leetcode.com/problems/k-diff-pairs-in-an-array/">532. K-diff Pairs in an Array</a>
 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String h = nums[j] + "+" + nums[i];
                if (set.contains(h)) {
                    continue;
                }
                int diff = nums[j] - nums[i];
                if (diff == k) {
                    set.add(h);
                    cnt++;
                } else if (diff > k) {
                    break;
                }
            }
        }
        return cnt;
    }

    public int betterOne(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    cnt++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Test
    public void test01() {
        assertEquals(2, findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        assertEquals(1, findPairs(new int[]{3, 1, 4, 1, 5}, 0));
        assertEquals(4, findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void test02() {
        assertEquals(2, betterOne(new int[]{3, 1, 4, 1, 5}, 2));
        assertEquals(1, betterOne(new int[]{3, 1, 4, 1, 5}, 0));
        assertEquals(4, betterOne(new int[]{1, 2, 3, 4, 5}, 1));
    }
}
