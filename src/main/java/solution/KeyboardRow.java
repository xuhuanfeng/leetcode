package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 7:40
 * @see <a href="https://leetcode.com/problems/keyboard-row/">500. Keyboard Row</a>
 */
public class KeyboardRow {

    private static Map<Character, Integer> maps = new HashMap<>();

    static {
        String firstLine = "qwertyuiop";
        fill(firstLine, 0);
        String secondLine = "asdfghjkl";
        fill(secondLine, 1);
        String thirdLine = "zxcvbnm";
        fill(thirdLine, 2);
    }

    private static void fill(String line, int num) {
        for (char c : line.toCharArray()) {
            maps.put(c, num);
        }
        for (char c : line.toUpperCase().toCharArray()) {
            maps.put(c, num);
        }
    }

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int index = 0;
            int firstVal = maps.get(word.charAt(0));
            for (char c : word.toCharArray()) {
                if (firstVal != maps.get(c)) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                result.add(word);
            }
        }
        return result.toArray(new String[]{});
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(findWords(new String[]{"abdfs", "cccd", "a", "qwwewm"})));
    }
}
