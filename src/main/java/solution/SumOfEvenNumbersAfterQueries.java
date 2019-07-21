package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Queue;

/**
 * @author huanfeng.xu
 * @date 2019-07-20 23:09
 * @see <a href="https://leetcode.com/problems/sum-of-even-numbers-after-queries/">985. Sum of Even Numbers After Queries</a>
 */
public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answer = new int[queries.length];
        int cnt = 0;
        int sum = 0;
        for (int i : A) {
            if ((i & 1) == 0) {
                sum += i;
            }
        }
        for (int[] query : queries) {
            int val = query[0];
            int index = query[1];
            if ((A[index] & 1) == 0 && (val & 1) == 0) {
                sum += val;
            } else if ((A[index] & 1) == 1 && (val & 1) == 1) {
                sum += A[index] + val;
            } else if ((A[index] & 1) == 0) {
                sum -= A[index];
            }
            A[index] += val;
            answer[cnt++] = sum;
        }
        return answer;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }
}
