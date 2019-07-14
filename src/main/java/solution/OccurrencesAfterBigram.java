package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 16:14
 * @see <a href="https://leetcode.com/problems/occurrences-after-bigram/">1078. Occurrences After Bigram</a>
 */
public class OccurrencesAfterBigram {

    public String[] findOcurrences(String text, String first, String second) {
        String[] textArray = text.split(" ");
        List<String> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < textArray.length - 1; i++) {
            if (textArray[i].equals(first) && textArray[i + 1].equals(second)) {
                if (i + 2 < textArray.length) {
                    result.add(textArray[i + 2]);
                }
            }
        }
        return result.toArray(new String[]{});
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(
                findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(findOcurrences("we will we will rock you", "we", "will")));
    }
}
