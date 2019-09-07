package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 7:57
 * @see <a href="https://leetcode.com/problems/maximize-distance-to-closest-person/">849. Maximize Distance to Closest Person</a>
 */
public class MaximizeDistanceToClosestPerson {
    /**
     * 这个题做得真艰难，主要是边界情况没有想清楚，wa了好多好多次，囧。。。
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int maxn = 0;
        int cnt = 0;
        int leftCnt = 0, rightCnt = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (cnt > 0 && maxn <= cnt) {
                maxn = cnt;
            }

            if (i == seats.length - 1) {
                rightCnt = cnt;
            } else if (cnt - 1 == i) {
                leftCnt = cnt;
            }
        }
        maxn = maxn / 2 + maxn % 2;
        int edgeMax = Math.max(leftCnt, rightCnt);
        return maxn > edgeMax ? maxn : edgeMax;
    }

    // official solution
    public int better(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                left[i] = 0;
            } else if (i > 0) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = N - 1; i >= 0; --i) {
            if (seats[i] == 1) {
                right[i] = 0;
            } else if (i < N - 1) {
                right[i] = right[i + 1] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; ++i) {
            if (seats[i] == 0) {
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;
    }

    @Test
    public void test01() {
        assertEquals(2, maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        assertEquals(3, maxDistToClosest(new int[]{1, 0, 0, 0}));
        assertEquals(3, maxDistToClosest(new int[]{0, 0, 0, 1}));
        assertEquals(1, maxDistToClosest(new int[]{1, 0, 0, 1}));
        assertEquals(2, maxDistToClosest(new int[]{0, 1, 1, 1, 0, 0, 1, 0, 0}));
        assertEquals(3, maxDistToClosest(new int[]{0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0}));
        assertEquals(2, maxDistToClosest(new int[]{0, 1, 0, 0, 0, 1, 1, 0, 1, 1}));
        assertEquals(3, maxDistToClosest(new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1}));
        assertEquals(3, maxDistToClosest(new int[]{1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0}));
    }
}
