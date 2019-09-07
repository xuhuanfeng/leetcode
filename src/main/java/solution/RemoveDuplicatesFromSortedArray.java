package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 6:58
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">26. Remove Duplicates from Sorted Array</a>
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int idx = 0;
        int head = 0;
        int len = nums.length;
        while (head < len) {
            if (nums[idx] == nums[head]) {
                head++;
            } else {
                nums[idx + 1] = nums[head];
                idx++;
            }
        }
        return idx + 1;
    }

    @Test
    public void test01() {
        int[] data = new int[]{1, 1, 1, 1};
        System.out.println(removeDuplicates(data));
        System.out.println(Arrays.toString(data));

        data = new int[]{1, 1, 2, 2, 3, 3};
        System.out.println(removeDuplicates(data));
        System.out.println(Arrays.toString(data));

        data = new int[]{1,2,3};
        System.out.println(removeDuplicates(data));
        System.out.println(Arrays.toString(data));
    }
}
