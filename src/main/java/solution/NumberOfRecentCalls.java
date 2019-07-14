package solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 12:56
 * @see <a href="https://leetcode.com/problems/number-of-recent-calls/">933. Number of Recent Calls</a>
 */
public class NumberOfRecentCalls {
    class RecentCounter {

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (!queue.isEmpty()) {
                Integer peek = queue.peek();
                if (peek < (t - 3000)) {
                    queue.poll();
                } else {
                    break;
                }
            }
            return queue.size();
        }
    }

    @Test
    public void test01() {
        RecentCounter recentCounter = new RecentCounter();
        assertEquals(1, recentCounter.ping(1));
        assertEquals(2, recentCounter.ping(100));
        assertEquals(3, recentCounter.ping(3001));
        assertEquals(3, recentCounter.ping(3002));
    }
}
