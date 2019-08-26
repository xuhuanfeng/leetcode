package solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-08-26 20:24
 * @see <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">989. Add to Array-Form of Integer</a>
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int tmp = A[i] + K;
            result.addFirst(tmp % 10);
            K = tmp / 10;
        }
        while (K != 0) {
            result.addFirst(K % 10);
            K /= 10;
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        System.out.println(addToArrayForm(new int[]{1, 0}, 100));
        System.out.println(addToArrayForm(new int[]{0}, 100));
    }
}
