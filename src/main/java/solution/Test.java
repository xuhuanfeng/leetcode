package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-10-13 10:30
 * @see
 */
public class Test {
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        int tcnt = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                tcnt++;
            } else {
                tcnt--;
            }
            if (tcnt == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        boolean[][] map = new boolean[8][8];
        for (int[] queen : queens) {
            map[queen[0]][queen[1]] = true;
        }

        List<List<Integer>> result = new ArrayList<>();

        // row
        for (int i = king[1] + 1; i < 8; i++) {
            if (map[king[0]][i]) {
                result.add(Arrays.asList(king[0], i));
                break;
            }
        }
        for (int i = king[1] - 1; i >= 0; i--) {
            if (map[king[0]][i]) {
                result.add(Arrays.asList(king[0], i));
                break;
            }
        }

        // col
        for (int i = king[0] + 1; i < 8; i++) {
            if (map[i][king[1]]) {
                result.add(Arrays.asList(i, king[1]));
                break;
            }
        }
        for (int i = king[0] - 1; i >= 0; i--) {
            if (map[i][king[1]]) {
                result.add(Arrays.asList(i, king[1]));
                break;
            }
        }

        // 1
        int c = king[1] + 1;
        for (int i = king[0] + 1; i < 8 && c < 8; i++, c++) {
            if (map[i][c]) {
                result.add(Arrays.asList(i, c));
                break;
            }
        }
        c = king[1] - 1;
        for (int i = king[0] - 1; i >= 0 && c >= 0; i--, c--) {
            if (map[i][c]) {
                result.add(Arrays.asList(i, c));
                break;
            }
        }

        // -1
        c = king[1] - 1;
        for (int i = king[0] + 1; i < 8 && c >= 0; i++, c--) {
            if (map[i][c]) {
                result.add(Arrays.asList(i, c));
                break;
            }
        }
        c = king[1] + 1;
        for (int i = king[0] - 1; i >= 0 && c < 8; i--, c++) {
            if (map[i][c]) {
                result.add(Arrays.asList(i, c));
                break;
            }
        }
        return result;
    }

    @org.junit.Test
    public void test01() {
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLRRL"));
        System.out.println(balancedStringSplit("RRLRRLRLLLRL"));
    }

    @org.junit.Test
    public void test02() {
        System.out.println(queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0}));
        System.out.println(queensAttacktheKing(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}}, new int[]{3, 3}));
        System.out.println(queensAttacktheKing(new int[][]{{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}}, new int[]{3, 4}));
    }
}
