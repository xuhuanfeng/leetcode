package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 8:51
 * @see <a href="https://leetcode.com/problems/roman-to-integer/">13. Roman to Integer</a>
 */
public class RomanToInteger {
    private Map<Character, Integer> map = new HashMap<>();

    private void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        init();
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {

            if (i + 1 >= chars.length) {
                sum += map.get(chars[i]);
            } else {
                if (chars[i] == 'I') {
                    if (chars[i + 1] == 'V' || chars[i + 1] == 'X') {
                        sum += (map.get(chars[i + 1]) - map.get(chars[i]));
                        i++;
                    } else {
                        sum += map.get(chars[i]);
                    }
                } else if (chars[i] == 'X') {
                    if (chars[i + 1] == 'L' || chars[i + 1] == 'C') {
                        sum += (map.get(chars[i + 1]) - map.get(chars[i]));
                        i++;
                    } else {
                        sum += map.get(chars[i]);
                    }
                } else if (chars[i] == 'C') {
                    if (chars[i + 1] == 'D' || chars[i + 1] == 'M') {
                        sum += (map.get(chars[i + 1]) - map.get(chars[i]));
                        i++;
                    } else {
                        sum += map.get(chars[i]);
                    }
                } else {
                    sum += map.get(chars[i]);
                }
            }
        }
        return sum;
    }

    @Test
    public void test01() {
        assertEquals(3, romanToInt("III"));
        assertEquals(4, romanToInt("IV"));
        assertEquals(9, romanToInt("IX"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(1994, romanToInt("MCMXCIV"));
    }
}
