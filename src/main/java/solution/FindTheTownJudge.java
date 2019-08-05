package solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-05 21:04
 * @see <a href="https://leetcode.com/problems/find-the-town-judge/">997. Find the Town Judge</a>
 */
public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] aToB = new int[1000 + 1];
        int[] bToA = new int[1000 + 1];
        for (int[] ints : trust) {
            aToB[ints[1]]++;
            bToA[ints[0]]++;
        }
        for (int i = 1; i < aToB.length; i++) {
            if (aToB[i] == N - 1 && bToA[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test01() {
        assertEquals(2, findJudge(2, new int[][]{{1, 2}}));
        assertEquals(3, findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        assertEquals(-1, findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        assertEquals(-1, findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        assertEquals(3, findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }
}
