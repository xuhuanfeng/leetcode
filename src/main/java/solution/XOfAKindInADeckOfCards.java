package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-13 8:40
 * @see <a href="https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/">914. X of a Kind in a Deck of Cards</a>
 */
public class XOfAKindInADeckOfCards {

    private static final int SIZE = 10000;

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        int[] data = new int[SIZE];
        for (int i : deck) {
            data[i]++;
        }

        int min = Integer.MAX_VALUE;
        for (int datum : data) {
            if (datum > 0 && datum < min) {
                min = datum;
            }
        }

        for (int i = min; i > 1; i--) {
            if (min % i == 0) {
                int j;
                for (j = 0; j < data.length; j++) {
                    if (data[j] > 0 && data[j] % i != 0) {
                        break;
                    }
                }
                if (j == data.length) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test01() {
        assertTrue(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        assertTrue(hasGroupsSizeX(new int[]{1, 1}));
        assertTrue(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        assertFalse(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
    }

}
