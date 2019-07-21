package solution;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 8:40
 * @see <a href="https://leetcode.com/problems/baseball-game/">682. Baseball Game</a>
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> data = new Stack<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                data.pop();
            } else if ("+".equals(op)) {
                int second = data.pop();
                int first = data.peek();
                data.push(second);
                data.push(second + first);
            } else if ("D".equals(op)) {
                data.push(data.peek() * 2);
            } else {
                data.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!data.isEmpty()) {
            sum += data.pop();
        }
        return sum;
    }

    @Test
    public void test01() {
        assertEquals(30, calPoints(new String[]{"5", "2", "C", "D", "+"}));
        assertEquals(27, calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
