package solution;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-11 8:13
 * @see <a href="https://leetcode.com/problems/backspace-string-compare/">844. Backspace String Compare</a>
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!stackS.empty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (!stackT.empty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(c);
            }
        }
        if (stackS.size() != stackT.size()) {
            return false;
        }
        while (!stackS.empty() && !stackT.empty()) {
            if (!stackS.peek().equals(stackT.peek())) {
                return false;
            }
            stackS.pop();
            stackT.pop();
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(backspaceCompare("ab#c", "ad#c"));
        assertTrue(backspaceCompare("ab##", "c#d#"));
        assertFalse(backspaceCompare("a#c", "b"));
        assertTrue(backspaceCompare("a##c", "#a#c"));
    }
}
