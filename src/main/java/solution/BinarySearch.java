package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-06 21:15
 * @see <a href="https://leetcode.com/problems/binary-search/">704. Binary Search</a>
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void test01() {
        assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
