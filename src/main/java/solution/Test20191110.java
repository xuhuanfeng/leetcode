package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Test20191110 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] data = new int[n][m];
        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];

            for (int i = 0; i < m; i++) {
                data[row][i]++;
            }

            for (int i = 0; i < n; i++) {
                data[i][col]++;
            }
        }

        int ans = 0;
        for (int[] datum : data) {
            for (int i : datum) {
                if ((i & 1) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0;
        int twoCnt = 0;
        for (int i : colsum) {
            sum += i;
            if (i == 2) {
                twoCnt++;
            }
        }

        if (upper + lower != sum || lower < twoCnt || upper < twoCnt) {
            return new ArrayList<>();
        }

        int[][] ans = new int[2][colsum.length];

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                ans[0][i] = ans[1][i] = 1;
                lower--;
                upper--;
            }
        }

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    ans[0][i] = 1;
                    upper--;
                } else {
                    ans[1][i] = 1;
                    lower--;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();
        for (int i : ans[0]) {
            upperList.add(i);
        }

        for (int i : ans[1]) {
            lowerList.add(i);
        }
        result.add(upperList);
        result.add(lowerList);
        return result;
    }

    @Test
    public void test01() {
        assertEquals(6, oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        assertEquals(0, oddCells(2, 2, new int[][]{{1, 1}, {0, 0}}));
    }

    @Test
    public void test02() {
        // System.out.println(reconstructMatrix(2, 1, new int[]{1, 1, 1}));
        // System.out.println(reconstructMatrix(2, 3, new int[]{2, 2, 1, 1}));
        // System.out.println(reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
        // System.out.println(reconstructMatrix(4, 7, new int[]{2, 1, 2, 2, 1, 1, 1}));
        System.out.println(reconstructMatrix(53, 82, new int[]{2, 0, 2, 1, 1, 2, 2, 0, 1, 1, 1, 0, 0, 0, 0, 2, 1, 2, 2, 2, 1, 1, 0, 0, 0, 0, 1, 2, 1, 0, 1, 0, 2, 0, 0, 0, 0, 2, 1, 1, 2, 1, 1, 0, 0, 1, 0, 0, 1, 1, 2, 0, 1, 1, 1, 2, 1, 0, 0, 1, 1, 1, 2, 2, 1, 0, 0, 1, 1, 1, 0, 2, 1, 2, 1, 0, 1, 2, 0, 2, 2, 1, 0, 1, 1, 1, 2, 0, 0, 0, 1, 2, 2, 0, 0, 1, 1, 2, 1, 2}));
//        System.out.println(reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
    }
}
