package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 12:43
 * @see <a href="https://leetcode.com/problems/array-partition-i/">561. Array Partition I</a>
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

    @Test
    public void test01() {
        assertEquals(4, arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
