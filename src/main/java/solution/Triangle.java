package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/triangle/">120. Triangle</a>
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                dp[i][j] += triangle.get(i).get(j);
            }
        }
        int min = dp[size - 1][0];
        for (int i = 1; i < size; i++) {
            min = Math.min(min, dp[size - 1][i]);
        }
        return min;
    }

    // better one
    public int minimumTotal1(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];

        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    dp[j] = dp[j - 1];
                } else if (j != 0) {
                    dp[j] = Math.min(dp[j], dp[j - 1]);
                }
                dp[j] += triangle.get(i).get(j);
            }
        }

        int min = dp[0];
        for (int i : dp) {
            min = Math.min(i, min);
        }
        return min;
    }

    @Test
    public void test() {
        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(2));
        data.add(Arrays.asList(3, 4));
        data.add(Arrays.asList(6, 5, 7));
        data.add(Arrays.asList(4, 1, 8, 3));
        Assert.assertEquals(11, minimumTotal(data));
        Assert.assertEquals(11, minimumTotal1(data));
    }
}
