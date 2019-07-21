package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 8:01
 * @see <a href="https://leetcode.com/problems/last-stone-weight/">1046. Last Stone Weight</a>
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(stones.length, (i1, i2) -> i2 - i1);
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }

        for (int i = 0; i < stones.length - 1; i++) {
            priorityQueue.offer(priorityQueue.poll() - priorityQueue.poll());
        }
        return priorityQueue.poll();
    }

    @Test
    public void test01() {
        assertEquals(1, lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        assertEquals(0, lastStoneWeight(new int[]{2, 2}));
    }
}
