package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-07-22 20:27
 * @see <a href="https://leetcode.com/problems/next-greater-element-i/">496. Next Greater Element I</a>
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    maps.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = maps.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
