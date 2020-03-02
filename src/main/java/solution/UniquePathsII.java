package solution;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        if (obstacleGrid[r - 1][c - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[r][c];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < r; i++) {
            dp[i][0] = obstacleGrid[i - 1][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < c; i++) {
            dp[0][i] = obstacleGrid[0][i - 1] == 1 ? 0 : dp[0][i - 1];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i - 1][j] == 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] == 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[r - 1][c - 1];
    }

    @Test
    public void test() {
        int[][] map = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        Assert.assertEquals(2, uniquePathsWithObstacles(map));
    }

    @Test
    public void test1() {
        int[][] map = {{0, 1}};
        Assert.assertEquals(0, uniquePathsWithObstacles(map));
    }
}
