package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-08-19 21:26
 * @see <a href="https://leetcode.com/problems/pascals-triangle-ii/">119. Pascal's Triangle II</a>
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[][] result = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            result[i][0] = 1;
            for (int j = 1; j < i; j++) {
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
            result[i][i] = 1;
        }

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            data.add(result[rowIndex][i]);
        }
        return data;
    }

    @Test
    public void test01() {
        System.out.println(getRow(3));
    }
}
