package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2020-03-02 19:30
 * @see <a href="https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/"></a>
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    class Node implements Comparable<Node> {

        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return num - o.num;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", num=" + num +
                    '}';
        }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Node> list = new ArrayList<>(groupSizes.length);

        for (int i = 0; i < groupSizes.length; i++) {
            list.add(new Node(i, groupSizes[i]));
        }
        Collections.sort(list);

        List<List<Integer>> result = new ArrayList<>();
        int cnt = 0;
        while (cnt < list.size()) {
            Node node = list.get(cnt);

            List<Integer> tmp = new ArrayList<>(node.num);
            int tcnt = 0;
            while (tcnt < node.num) {
                Node node1 = list.get(cnt);
                tmp.add(node1.idx);
                tcnt++;
                cnt++;
            }
            result.add(tmp);
        }
        return result;
    }

    public List<List<Integer>> groupThePeople1(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            Integer key = integerListEntry.getKey();
            List<Integer> tmp = new ArrayList<>();
            List<Integer> value = integerListEntry.getValue();
            for (int i = 1; i - 1 < value.size(); i++) {
                tmp.add(value.get(i - 1));

                if ((i % key) == 0) {
                    result.add(tmp);
                    tmp = new ArrayList<>();
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[] data = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(data));
    }

    @Test
    public void test01() {
        int[] data = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople1(data));
    }
}
