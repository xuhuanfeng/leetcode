package solution;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 9:49
 * @see <a href="https://leetcode.com/problems/robot-return-to-origin/">657. Robot Return to Origin</a>
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int rCnt = 0, lCnt = 0, uCnt = 0, dCnt = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    rCnt++;
                    break;
                case 'L':
                    lCnt++;
                    break;
                case 'D':
                    dCnt++;
                    break;
                case 'U':
                    uCnt++;
                    break;
                default:
                    break;
            }
        }
        return rCnt == lCnt && uCnt == dCnt;
    }

    public boolean another(String moves) {
        int h = 0, v = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    h++;
                    break;
                case 'L':
                    h--;
                    break;
                case 'D':
                    v--;
                    break;
                case 'U':
                    v++;
                    break;
                default:
                    break;
            }
        }
        return h == 0 && v == 0;
    }

    @Test
    public void test01() {
        assertTrue(judgeCircle("UD"));
        assertFalse(judgeCircle("LL"));
    }

    @Test
    public void test02() {
        assertTrue(another("UD"));
        assertFalse(another("LL"));
    }
}
