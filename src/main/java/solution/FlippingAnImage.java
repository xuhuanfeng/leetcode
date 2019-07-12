package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-12 22:21
 * @see <a href="https://leetcode.com/problems/flipping-an-image/">832. Flipping an Image</a>
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) {
            return A;
        }

        int rowLen = A.length;
        int colLen = A[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int i1 = 0; i1 < colLen / 2; i1++) {
                int tmp = A[i][i1] == 0 ? 1 : 0;
                A[i][i1] = A[i][colLen - 1 - i1] == 0 ? 1 : 0;
                A[i][colLen - 1 - i1] = tmp;
            }
            if ((colLen & 1) == 1) {
                int tmp = A[i][colLen / 2] == 0 ? 1 : 0;
                A[i][colLen / 2] = tmp;
            }
        }
        return A;
    }

    public int[][] another(int[][] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            // 这里非常巧妙，奇数的情况下也可以起作用，
            // 奇数时，如 5， len / 2 + len % 2 = 3，即 n = 2(中间数)也考虑在内
            // 但此时 a[i][2] = a[i][5 - 1 - 2]，所以，相当于只^1一次
            for (int i1 = 0; i1 < len / 2 + len % 2; i1++) {
                int tmp = A[i][i1];
                A[i][i1] = A[i][len - 1 - i1] ^ 1;
                A[i][len - 1 - i1] = tmp ^ 1;

            }
        }
        return A;
    }

    public int[][] bestOne(int[][] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            // 奇数时，中间数 * 2 < len，如 3/2 * 2 < 3，参与运算
            for (int i1 = 0; i1 * 2 < len ; i1++) {
                if (A[i][i1] == A[i][len - 1 - i1]) {
                    // 非常巧妙，如果两个数不相同，交换后再翻转，等于本身，如 1 0 -> 0 1 -> 1 0
                    // 如果相同，则直接取反即可
                    A[i][i1] = A[i][len - 1 - i1] ^= 1;
                }
            }
        }
        return A;
    }

    @Test
    public void test01() {
        int data[][] = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(data)));
        int data1[][] = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(data1)));
    }

    @Test
    public void test02() {
        int data[][] = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(another(data)));
        int data1[][] = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(another(data1)));
    }

    @Test
    public void test03() {
        int data[][] = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(bestOne(data)));
        int data1[][] = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(bestOne(data1)));
    }
}
