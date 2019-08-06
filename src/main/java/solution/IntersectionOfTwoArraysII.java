package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-08-06 21:27
 * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">350. Intersection of Two Arrays II</a>
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> data = new ArrayList<>(nums2.length);
        int idx = 0;
        for (int i : nums2) {
            Integer val = map.get(i);
            if (val != null && val > 0) {
                data.add(i);
                idx++;
                map.put(i, val - 1);
            }
        }

        int[] result = new int[idx];
        for (int i = 0; i < idx; i++) {
            result[i] = data.get(i);
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
