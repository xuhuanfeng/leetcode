package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 21:33
 * @see <a href="https://leetcode.com/problems/available-captures-for-rook/">999. Available Captures for Rook</a>
 */
public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        int result = 0;
        int len = board.length;
        int postX = -1, postY = -1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 'R') {
                    postX = i;
                    postY = j;
                    break;
                }
            }
            if (postX != -1) {
                break;
            }
        }

        int tmpX = postX;
        while (tmpX > 0) {
            if (board[tmpX][postY] == 'B') {
                break;
            }else if (board[tmpX][postY] == 'p') {
                result++;
                break;
            }
            tmpX--;
        }

        tmpX = postX;
        while (tmpX < len) {
            if (board[tmpX][postY] == 'B') {
                break;
            }else if (board[tmpX][postY] == 'p') {
                result++;
                break;
            }
            tmpX++;
        }

        int tmpY = postY;
        while (tmpY > 0) {
            if (board[postX][tmpY] == 'B') {
                break;
            }else if (board[postX][tmpY] == 'p') {
                result++;
                break;
            }
            tmpY--;
        }

        tmpY = postY;
        while (tmpY < len) {
            if (board[postX][tmpY] == 'B') {
                break;
            }else if (board[postX][tmpY] == 'p') {
                result++;
                break;
            }
            tmpY++;
        }
        return result;
    }

    @Test
    public void test01() {
        char[][] board = new char[][] {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'p','p','.','R','.','p','B','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','B','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}};
        assertEquals(3, numRookCaptures(board));
        
        board = new char[][] {
                {'.','.','.','.','.','.','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','B','R','B','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}};
        assertEquals(0, numRookCaptures(board));
    }
}
