package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-11 22:42
 * @see <a href="https://leetcode.com/problems/remove-outermost-parentheses/">
 * 1021. Remove Outermost Parentheses</a>
 */
public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        StringBuilder builder = new StringBuilder();
        int length = S.length();
        int cnt = 0;
        int pre = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }
            if (cnt == 0) {
                if (pre + 1 < i) {
                    builder.append(S, pre + 1, i);
                }
                pre = i + 1;
            }
        }
        return builder.toString();
    }

    public String another(String S) {
        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && ++cnt > 1) {
                builder.append(c);
            }
            if (c == ')' && --cnt > 0) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    @Test
    public void test01() {
        assertEquals("()()()", removeOuterParentheses("(()())(())"));
        assertEquals("()()()()(())", removeOuterParentheses("(()())(())(()(()))"));
        assertEquals("", removeOuterParentheses("()()"));
    }

    @Test
    public void test02() {
        assertEquals("()()()", another("(()())(())"));
        assertEquals("()()()()(())", another("(()())(())(()(()))"));
        assertEquals("", another("()()"));
    }
}
