package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 19:45
 * @see <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/">953. Verifying an Alien Dictionary</a>
 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> maps = new HashMap<>(words.length);
        for (int i = 0; i < order.toCharArray().length; i++) {
            maps.put(order.charAt(i), i);
        }
        String[] clone = words.clone();
        Arrays.sort(words, (o1, o2) -> {
            int str1Len = o1.length();
            int str2Len = o2.length();

            char[] chars1 = o1.toCharArray();
            char[] chars2 = o2.toCharArray();

            int min = Math.min(str1Len, str2Len);
            for (int i = 0; i < min; i++) {
                Integer a = maps.getOrDefault(chars1[i], 0);
                Integer b = maps.getOrDefault(chars2[i], 0);
                if (a != b) {
                    return a - b;
                }
            }
            return str1Len - str2Len;
        });

        for (int i = 0; i < clone.length; i++) {
            if (!clone[i].equals(words[i])) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        assertFalse(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        assertTrue(isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
    }
}
