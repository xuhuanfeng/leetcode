package solution;

import org.junit.Test;

import java.util.Stack;

/**
 * @author huanfeng.xu
 * @date 2019-07-16 22:20
 * @see <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">1047. Remove All Adjacent Duplicates In String</a>
 */
public class RemoveAllAdjacentDuplicatesInString {
    // 这个题没有做出来
    // 这种出来方式太有趣了
    public String removeDuplicates(String S) {
        char[] stack = new char[S.length()];
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (cnt - 1 >= 0 && stack[cnt - 1] == c) {
                cnt--;
            } else {
                stack[cnt++] = c;
            }
        }
        return new String(stack, 0, cnt);
    }

    @Test
    public void test01() {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("abab"));
        System.out.println(removeDuplicates("aabaab"));
        System.out.println(removeDuplicates("aabaac"));
        System.out.println(removeDuplicates("aaaaaaa"));
        System.out.println(removeDuplicates("abbbabaaa"));
    }
}
