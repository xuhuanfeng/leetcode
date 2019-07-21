package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 9:58
 * @see <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/">884. Uncommon Words from Two Sentences</a>
 */
public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        for (String s : A.split(" ")) {
            mapA.merge(s, 1, (a, b) -> a + b);
        }
        // System.out.println(mapA);
        for (String s : B.split(" ")) {
            mapB.merge(s, 1, (a, b) -> a + b);
        }
        // System.out.println(mapB);

        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            if (entry.getValue() == 1 && mapB.get(entry.getKey()) == null) {
                result.add(entry.getKey());
            }
        }

        for (Map.Entry<String, Integer> entry : mapB.entrySet()) {
            if (entry.getValue() == 1 && mapA.get(entry.getKey()) == null) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[]{});
    }

    public String[] another(String A, String B) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : (A + " " + B).split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[]{});
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple", "banana")));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(another("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(another("apple apple", "banana")));
    }
}
