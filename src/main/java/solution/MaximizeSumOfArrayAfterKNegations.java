package solution;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 15:30
 * @see <a href="https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/">1005. Maximize Sum Of Array After K Negations</a>
 */
public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : A) {
            queue.offer(i);
        }

        while (K-- > 0) {
            Integer poll = queue.poll();
            queue.offer(-poll);
        }

        int sum = 0;
        for (Integer integer : queue) {
            sum += integer;
        }
        return sum;
    }

    @Test
    public void test01() {
        assertEquals(5, largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        assertEquals(6, largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
    }
}
