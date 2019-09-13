package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-09-12 20:08
 * @see <a href="https://leetcode.com/problems/word-pattern/">290. Word Pattern</a>
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> mapPattern = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] s = str.split(" ");
        if (chars.length != s.length) {
            return false;
        }
        int i = 0;
        while (i < chars.length) {
            String data = patternMap.get(chars[i]);
            Character c = mapPattern.get(s[i]);
            if (data == null && c == null) {
                patternMap.put(chars[i], s[i]);
                mapPattern.put(s[i], chars[i]);
            } else if (!s[i].equals(data) || chars[i] != c) {
                return false;
            }
            i++;
        }
        return true;
    }
}
