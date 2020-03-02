package solution;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class C20200105 {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        int len = chars.length;
        Map<String, String> map = new HashMap<>();
        for (int i = 10; i <= 26; i++) {
            map.put(String.valueOf(i), String.valueOf((char) ((i - 1) + 'a')));
        }
//        System.out.println(map);
        for (int i = 0; i < len; i++) {
            String tmp = "";
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (i + 2 < len && chars[i + 2] == '#') {
                    tmp = chars[i] + String.valueOf(chars[i + 1]);
                    result.append(map.get(tmp));
                    i += 2;
                } else {
                    result.append((char) (chars[i] - '1' + 'a'));
                }
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("jkab", freqAlphabets("10#11#12"));
        assertEquals("acz", freqAlphabets("1326#"));
        assertEquals("abcdefghijklmnopqrstuvwxyz", freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }


    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] helper = new int[arr.length];

        helper[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            helper[i] = helper[i - 1] ^ arr[i];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == queries[i][1]) {
                result[i] = arr[queries[i][0]];
            } else {
                result[i] = helper[queries[i][1]] ^ helper[queries[i][0]] ^ arr[queries[i][0]];
            }
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
        System.out.println(Arrays.toString(xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}})));
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        List<Integer> ff = getFriend(friends, id);
        level--;

        List<Integer> parent = new ArrayList<>();
        parent.add(id);

        while (level-- > 0) {
            Set<Integer> f = new HashSet<>();
            for (Integer fid : ff) {
                f.addAll(getFriend(friends, fid));
            }
            parent.addAll(ff);
            f.removeAll(parent);
            ff = new ArrayList<>(f);
        }

//        System.out.println(ff);

        Map<String, Node> map = new HashMap<>();
        for (Integer integer : ff) {
            List<String> videos = watchedVideos.get(integer);
            for (String video : videos) {
                Node node = map.getOrDefault(video, new Node(video, 0));
                node.fre += 1;
                map.put(video, node);
            }
        }

        ArrayList<Node> nodes = new ArrayList<>(map.values());
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.fre == o2.fre) {
                    return o1.name.compareTo(o2.name);
                }
                return o1.fre - o2.fre;
            }
        });
        List<String> result = new ArrayList<>();
        for (Node node : nodes) {
            result.add(node.name);
        }
        return result;
    }

    class Node {
        public String name;
        public int fre;

        public Node(String name, int fre) {
            this.name = name;
            this.fre = fre;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", fre=" + fre +
                    '}';
        }
    }

    private List<Integer> getFriend(int[][] my, int id) {
        List<Integer> list = new ArrayList<>();
        int[] friends = my[id];
        for (int friend : friends) {
            list.add(friend);
        }
        return list;
    }

    @Test
    public void test02() {
        List<List<String>> videos = new ArrayList<>();
        videos.add(Arrays.asList("A", "B"));
        videos.add(Arrays.asList("C"));
        videos.add(Arrays.asList("B", "C"));
        videos.add(Arrays.asList("D"));

        int[][] friends = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        System.out.println(watchedVideosByFriends(videos, friends, 0, 1));

        videos = new ArrayList<>();
        videos.add(Arrays.asList("bjwtssmu"));
        videos.add(Arrays.asList("aygr", "mqls"));
        videos.add(Arrays.asList("vrtxa", "zxqzeqy", "nbpl", "qnpl"));
        videos.add(Arrays.asList("r", "otazhu", "rsf"));
        videos.add(Arrays.asList("bvcca", "ayyihidz", "ljc", "fiq", "viu"));

        int[][] friend = {{3, 2, 1, 4}, {0, 4}, {4, 0}, {0, 4}, {2, 3, 1, 0}};
        System.out.println(watchedVideosByFriends(videos, friend, 3, 1));
    }

    public int minInsertions(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = chars.length; i >= 0; i--) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][chars.length - 1];
    }

    @Test
    public void test03() {
        System.out.println(minInsertions("noo"));
        System.out.println(minInsertions("zzazz"));
        System.out.println(minInsertions("leetcode"));
        System.out.println(minInsertions("no"));
        System.out.println(minInsertions("g"));
    }
}
