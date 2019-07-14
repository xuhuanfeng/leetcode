package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 13:14
 * @see <a href="https://leetcode.com/problems/delete-columns-to-make-sorted/">944. Delete Columns to Make Sorted</a>
 */
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        if (A == null) {
            return 0;
        }
        int row = A.length;
        int col = A[0].length();
        int cnt = 0;
        for (int i = 0; i < col; i++) {
            for (int i1 = 1; i1 < row; i1++) {
                if (A[i1].charAt(i) < A[i1 - 1].charAt(i)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    @Test
    public void test01() {
        assertEquals(1, minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        assertEquals(0, minDeletionSize(new String[]{"a", "b"}));
        assertEquals(3, minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }
}
