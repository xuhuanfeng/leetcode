package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-06 20:48
 * @see <a href="https://leetcode.com/problems/missing-number/">268. Missing Number</a>
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 1; i <= nums.length; i++) {
            result ^= i;
        }
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    @Test
    public void test01() {
        assertEquals(2, missingNumber(new int[]{3, 0, 1}));
        assertEquals(8, missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
