package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-03 20:32
 * @see <a href="https://leetcode.com/problems/find-pivot-index/">724. Find Pivot Index</a>
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            int right = sum - left - nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    @Test
    public void test01() {
        assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
        assertEquals(0, pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
    }
}
