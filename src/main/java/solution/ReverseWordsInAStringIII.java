package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-07-16 20:40
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">557. Reverse Words in a String III</a>
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int start = 0;
        int tLen = 0;
        int cnt = 1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                cnt = 1;
                tLen = i - start;
                for (int j = start; j < tLen / 2 + start; j++) {
                    char tmp = chars[j];
                    chars[j] = chars[i - cnt];
                    chars[i - cnt] = tmp;
                    cnt++;
                }
                start = i + 1;
            }
        }
        tLen = len - start;
        cnt = 1;
        for (int j = start; j < tLen / 2 + start; j++) {
            char tmp = chars[j];
            chars[j] = chars[len - cnt];
            chars[len - cnt] = tmp;
            cnt++;
        }
        return new String(chars);
    }

    public String another(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                int j = i;
                while (j < chars.length && chars[j] != ' ') {
                    j++;
                }

                int leftIndex = i, rightIndex = j - 1;
                while (leftIndex < rightIndex) {
                    char tmp = chars[leftIndex];
                    chars[leftIndex] = chars[rightIndex];
                    chars[rightIndex] = tmp;
                    leftIndex++;
                    rightIndex--;
                }
                i = j;
            }
        }
        return new String(chars);
    }

    @Test
    public void test01() {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("abc"));
    }

    @Test
    public void test02() {
        System.out.println(another("Let's take LeetCode contest"));
        System.out.println(another("abc"));
    }
}
