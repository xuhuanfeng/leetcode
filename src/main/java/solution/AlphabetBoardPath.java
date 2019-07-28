package solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 10:50
 * @see <a href="https://leetcode.com/contest/weekly-contest-147/problems/alphabet-board-path/">1138. Alphabet Board Path</a>
 */
public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        char[][] boards = new char[][]{
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'x', 'y'},
                {'z'}
        };

        StringBuilder builder = new StringBuilder();
        Queue<Move> queue = new LinkedList<>();

        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                queue.offer(new Move(boards[0][0], "", 0, 0));
            }
//            System.out.println("  -- " + chars[i]);
            while (!queue.isEmpty()) {
                Move head = queue.poll();
                if (head.val == chars[i]) {
//                    System.out.println(head.val);
                    builder.append(head.path).append("!");
                    queue.clear();
                    queue.offer(new Move(chars[i], "", head.mX, head.mY));
                    break;
                } else {
                    int tx = head.mX;
                    int tY = head.mY;
                    if (tY >= 0) {
                        if (tx - 1 >= 0 && tY < boards[tx - 1].length) {
                            queue.offer(new Move(boards[tx - 1][tY], head.path + "U", tx - 1, head.mY));
                        }
                        if (tx + 1 < boards.length && tY < boards[tx + 1].length) {
                            queue.offer(new Move(boards[tx + 1][tY], head.path + "D", tx + 1, tY));
                        }
                    }
                    if (tx >= 0 && tx < boards.length) {
                        if (tY - 1 >= 0) {
                            queue.offer(new Move(boards[tx][tY - 1], head.path + "L", tx, tY - 1));
                        }
                        if (tY + 1 < boards[tx].length) {
                            queue.offer(new Move(boards[tx][tY + 1], head.path + "R", tx, tY + 1));
                        }
                    }
                    // System.out.println(head.val);
                }
            }
        }
        return builder.toString();
    }

    class Move {
        public char val;
        public String path;
        public int mX;
        public int mY;

        public Move(char val, String path, int mX, int mY) {
            this.val = val;
            this.path = path;
            this.mX = mX;
            this.mY = mY;
        }
    }

    @Test
    public void test01() {
        System.out.println(alphabetBoardPath("leet"));
        System.out.println(alphabetBoardPath("code"));
    }
}
