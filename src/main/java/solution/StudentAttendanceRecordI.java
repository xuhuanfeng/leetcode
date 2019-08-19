package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-13 21:10
 * @see <a href="https://leetcode.com/problems/student-attendance-record-i/">551. Student Attendance Record I</a>
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int aCnt = 0;
        int lCnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                aCnt++;
            } else if (chars[i] == 'L') {
                if (i - 1 >= 0 && chars[i - 1] == 'L') {
                    lCnt++;
                } else {
                    lCnt = 1;
                }
            }
            if (aCnt > 1 || lCnt > 2) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(checkRecord("PPALLP"));
        assertFalse(checkRecord("PPALLL"));
        assertFalse(checkRecord("LLLALL"));
    }
}
