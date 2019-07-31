package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-31 22:21
 * @see <a href="https://leetcode.com/problems/majority-element/">169. Majority Element</a>
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int another(int[] nums) {
        int major = 0, counter = 0;
        for (int num : nums) {
            if (counter == 0) {
                counter++;
                major = num;
            } else if (major == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return major;
    }

    @Test
    public void test01() {
        assertEquals(3, majorityElement(new int[]{3, 2, 3}));
        assertEquals(2, majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    public void test02() {
        assertEquals(3, another(new int[]{3, 2, 3}));
        assertEquals(2, another(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
