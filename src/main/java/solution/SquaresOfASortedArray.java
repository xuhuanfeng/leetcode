package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 9:03
 * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
 */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] another(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        int i = 0, j = len - 1;
        for (int idx = len - 1; idx >= 0; idx--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[idx] = A[i] * A[i];
                i++;
            }else {
                result[idx] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-3, -3, -2, 1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-2, 1})));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(another(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(another(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(another(new int[]{-3, -3, -2, 1})));
        System.out.println(Arrays.toString(another(new int[]{-2, 1})));
    }
}
