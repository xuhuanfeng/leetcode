package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-12 20:34
 * @see <a href="https://leetcode.com/problems/valid-mountain-array/">941. Valid Mountain Array</a>
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int head = 0;
        int tail = 0;
        for (int i = 0; i < A.length; i++) {
            if (i - 1 >= 0 && i + 1 < A.length) {
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    head++;
                }
                if (A[i - 1] > A[i] && A[i + 1] > A[i]) {
                    tail++;
                }
            }
            if (i - 1 >= 0 && A[i] == A[i - 1]) {
                return false;
            }
            if (head >= 2 || tail > 0) {
                return false;
            }
        }
        // System.out.println(head);
        return head == 1 && tail == 0;
    }

    @Test
    public void test01() {
        assertTrue(validMountainArray(new int[]{0, 3, 2, 1}));
    }
}
