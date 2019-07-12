package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-12 23:00
 * @see <a href="https://leetcode.com/problems/sort-array-by-parity/">905. Sort Array By Parity</a>
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            while (left < A.length && (A[left] & 1) == 0) {
                left++;
            }
            while (right >= 0 && (A[right] & 1) == 1) {
                right--;
            }
            if (left < right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
            }
            left++;
            right--;
        }
        return A;
    }

    public int[] another(int[] A) {
        int len = A.length;
        for (int i = 0, j = len - 1; i < j; ) {
            if ((A[i] & 1) == 0) {
                i++;
            } else if ((A[j] & 1) == 1) {
                j--;
            } else {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
                j--;
            }
        }
        return A;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1, 1, 2, 2, 3, 3, 4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0, 2})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1, 3})));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(another(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(another(new int[]{1, 1, 2, 2, 3, 3, 4})));
        System.out.println(Arrays.toString(another(new int[]{0, 2})));
        System.out.println(Arrays.toString(another(new int[]{1, 3})));
    }
}
