package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 11:07
 * @see <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">852. Peak Index in a Mountain Array</a>
 */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // 二分搜索
    public int another(int[] A) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test01() {
        assertEquals(1, peakIndexInMountainArray(new int[]{0, 1, 0}));
        assertEquals(1, peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }

    @Test
    public void test02() {
        assertEquals(1, another(new int[]{0, 1, 0}));
        assertEquals(1, another(new int[]{0, 2, 1, 0}));
        assertEquals(5, another(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90}));
    }
}
