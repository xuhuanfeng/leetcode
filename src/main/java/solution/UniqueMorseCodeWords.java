package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-12 22:08
 * @see <a href="https://leetcode.com/problems/unique-morse-code-words/">804. Unique Morse Code Words</a>
 */
public class UniqueMorseCodeWords {

    private static final String[] DATA = new String[]{
            ".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
            ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Map<String, Integer> resultMap = new HashMap<>(words.length);
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                builder.append(DATA[c - 'a']);
            }
            String result = builder.toString();
            Integer num = resultMap.getOrDefault(result, 0);
            resultMap.put(result, num + 1);
        }
        return resultMap.keySet().size();
    }

    public int another(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                builder.append(DATA[c - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }

    @Test
    public void test01() {
        assertEquals(2, uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    @Test
    public void test02() {
        assertEquals(2, another(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
