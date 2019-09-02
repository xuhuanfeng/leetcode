package solution;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-02 20:18
 * @see <a href="https://leetcode.com/problems/most-common-word/">819. Most Common Word</a>
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s.toLowerCase());
        }

        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.split("[ !?',;.]");
        for (String word : words) {
            String str = word.toLowerCase();
            if (!bannedSet.contains(str) && !"".equals(str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        String ans = "";
        Integer max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }

    @Test
    public void test01() {
        assertEquals("ball",
                mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
