package solution;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 10:38
 * @see <a href="https://leetcode.com/contest/weekly-contest-154/problems/reverse-substrings-between-each-pair-of-parentheses/">
 *     5190. Reverse Substrings Between Each Pair of Parentheses</a>
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] helper = new char[2000 + 1];
        for (char c : s.toCharArray()) {
            if (c == ')') {
                int idx = 0;
                while (true) {
                    Character pop = stack.pop();
                    if (pop == '(') {
                        break;
                    }
                    helper[idx++] = pop;
                }
//                System.out.println(helper);
                int i = 0;
                while (i < idx) {
                    stack.push(helper[i++]);
                }
//                System.out.println(stack);
            } else {
                stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    @Test
    public void test01() {
        assertEquals("apmnolkjihgfedcbq", reverseParentheses("a(bcdefghijkl(mno)p)q"));
        assertEquals("leetcode", reverseParentheses("(ed(et(oc))el)"));
        assertEquals("iloveu", reverseParentheses("(u(love)i)"));
    }
}
