package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-17 21:03
 * @see <a href="https://leetcode.com/problems/third-maximum-number/">414. Third Maximum Number</a>
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int secondMax = min;
        for (int num : nums) {
            if (num != max && num > secondMax) {
                secondMax = num;
            }
        }

        int thirdMax = min;
        for (int num : nums) {
            if (num != max && num != secondMax && num > thirdMax) {
                thirdMax = num;
            }
        }
        if (thirdMax == secondMax || thirdMax == max) {
            return max;
        }
        return thirdMax;
    }

    @Test
    public void test01() {
        // assertEquals(1, thirdMax(new int[]{1, 2, 3}));
        // assertEquals(2, thirdMax(new int[]{1, 2}));
        // assertEquals(1, thirdMax(new int[]{1, 2, 2, 3}));
        assertEquals(-2147483648, thirdMax(new int[]{1, 2, -2147483648}));
    }
}
