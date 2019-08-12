package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-08-10 10:28
 * @see <a href="https://leetcode.com/problems/pascals-triangle/">118. Pascal's Triangle</a>
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if (i >= 2) {
                List<Integer> preRow = result.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            if (i > 0) {
                row.add(1);
            }
            result.add(row);
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(generate(5));
    }
}
