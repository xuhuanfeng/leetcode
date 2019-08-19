package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-08-18 10:31
 * @see
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        for (char c : chars.toCharArray()) {
            cnt[c - 'a']++;
        }

        int result = 0;
        for (String word : words) {
            int[] tmp = new int[26];
            for (char c : word.toCharArray()) {
                tmp[c - 'a']++;
            }
            int i;
            for (i = 0; i < 26; i++) {
                if (tmp[i] > cnt[i]) {
                    break;
                }
            }
            if (i == 26) {
                result += word.length();
            }
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
