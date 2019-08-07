package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-08-07 20:42
 * @see <a href="https://leetcode.com/problems/minimum-index-sum-of-two-lists/">599. Minimum Index Sum of Two Lists<a/>
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minIndex = list1.length + list2.length;
        for (int i = 0; i < list2.length; i++) {
            Integer datum = map.get(list2[i]);
            if (datum == null) {
                continue;
            }
            if (datum + i < minIndex) {
                minIndex = datum + i;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer datum = map.get(list2[i]);
            if (datum != null && datum + i == minIndex) {
                result.add(list2[i]);
            }
        }
        return result.toArray(new String[0]);
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));
    }
}