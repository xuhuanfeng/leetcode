package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-07-24 21:45
 * @see <a href="https://leetcode.com/problems/letter-case-permutation/">784. Letter Case Permutation</a>
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        Set<String> set = new HashSet<>();
        char[] chars = S.toCharArray();
        permutation(set, chars, 0);
        List<String> list = new ArrayList<>(set);
        return list;
    }

    private void permutation(Set<String> list, char[] data, int index) {
        if (index < data.length) {
            char c = data[index];
            list.add(new String(data));
            permutation(list, data, index + 1);
            if (c >= 'A' && c <= 'Z') {
                data[index] = (char) (c + ('a' - 'A'));
            } else if (c >= 'a' && c <= 'z') {
                data[index] = (char) (c - ('a' - 'A'));
            }
            list.add(new String(data));
            permutation(list, data, index + 1);
        }
    }


    public List<String> another(String S) {
        List<String> result = new LinkedList<>();
        anotherPermutation(result, S.toCharArray(), 0);
        return result;
    }


    public void anotherPermutation(List<String> data, char[] s, int index) {
        if (index == s.length) {
            data.add(new String(s));
            return;
        }
        if (s[index] >= '0' && s[index] <= '9') {
            anotherPermutation(data, s, index + 1);
            return;
        }
        s[index] = Character.toLowerCase(s[index]);
        anotherPermutation(data, s, index + 1);

        s[index] = Character.toUpperCase(s[index]);
        anotherPermutation(data, s, index + 1);
    }

    @Test
    public void test01() {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));
        System.out.println(letterCasePermutation("C"));
    }

    @Test
    public void test02() {
        System.out.println(another("a1b2"));
        System.out.println(another("3z4"));
        System.out.println(another("12345"));
        System.out.println(another("C"));
    }
}
