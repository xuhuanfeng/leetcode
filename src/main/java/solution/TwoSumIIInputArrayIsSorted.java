package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 9:45
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input array is sorted</a>
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int rightIndex = doFind(numbers, target - numbers[i]);
            if (rightIndex != -1 && rightIndex != i) {
                if (rightIndex > i) {
                    return new int[]{i + 1, rightIndex + 1};
                } else {
                    return new int[]{rightIndex + 1, i + 1};
                }
            }
        }
        return null;
    }

    public int doFind(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int[] another(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if (tmp < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(another(new int[]{2, 7, 11, 15}, 9)));
    }
}
