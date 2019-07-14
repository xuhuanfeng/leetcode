package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 15:50
 * @see <a href="https://leetcode.com/problems/sort-array-by-parity-ii/">922. Sort Array By Parity II</a>
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] odd = new int[len / 2];
        int[] even = new int[len / 2];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i : A) {
            if ((i & 1) == 0) {
                even[evenIndex++] = i;
            } else {
                odd[oddIndex++] = i;
            }
        }
        oddIndex = evenIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if ((i & 1) == 0) {
                A[i] = even[evenIndex++];
            } else {
                A[i] = odd[oddIndex++];
            }
        }
        return A;
    }

    /**
     * 将奇数放在奇数位置上，当所有的奇数放完，那么所有的偶数也就在对应位置上了
     */
    public int[] another(int[] A) {
        int len = A.length;
        int oddIndex = 1, evenIndex = 0;
        while (oddIndex < len && evenIndex < len) {
            if ((A[evenIndex] & 1) != 0) {
                int temp = A[evenIndex];
                A[evenIndex] = A[oddIndex];
                A[oddIndex] = temp;
                oddIndex += 2;
            } else {
                evenIndex += 2;
            }
        }
        return A;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(another(new int[]{4, 2, 5, 7})));
    }
}
