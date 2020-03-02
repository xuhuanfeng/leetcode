package solution;

import org.junit.Test;

import java.util.*;

/**
 * contest 20200301
 *
 * @author xuhf001
 * @date 2020-03-01 10:23
 * @see <a href="https://leetcode.com/contest/weekly-contest-178"></a>
 */
public class C20200301 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) {
                    cnt++;
                }
            }
            result[i] = cnt;
        }
        return result;
    }

    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] num = new int[101];
        for (int i : nums) {
            num[i]++;
        }

        int[] helper = new int[num.length];
        helper[0] = 0;
        for (int i = 1; i < num.length; i++) {
            helper[i] = helper[i - 1] + num[i - 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = helper[nums[i]];
        }

        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
    }

    @Test
    public void test011() {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent1(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent1(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent1(new int[]{7, 7, 7, 7})));
    }


    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) {
            return "";
        }

        Map<Character, int[]> map = new HashMap<>();
        int len = votes[0].length();
        for (String vote : votes) {
            for (int i = 0; i < len; i++) {
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[len]);
                map.get(c)[i]++;
            }
        }

        ArrayList<Character> characters = new ArrayList<>(map.keySet());
        characters.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                for (int i = 0; i < len; i++) {
                    if (map.get(o1)[i] != map.get(o2)[i]) {
                        return map.get(o2)[i] - map.get(o1)[i];
                    }
                }
                return o1 - o2;
            }
        });

        StringBuilder result = new StringBuilder();
        for (Character character : characters) {
            result.append(character);
        }
        return result.toString();
    }


    @Test
    public void test02() {
        String[] data = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println(rankTeams(data));
        System.out.println(rankTeams(new String[]{"M", "M", "M"}));
        System.out.println(rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
        System.out.println(rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
        System.out.println(rankTeams(new String[]{"WXYZ", "XYZW"}));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    boolean doFind(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        } else if (root == null) {
            return false;
        }

        return root.val == head.val && (doFind(head.next, root.left) || doFind(head.next, root.right));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        } else if (root == null) {
            return false;
        }
        boolean isFind = doFind(head, root);
        return isFind || (isSubPath(head, root.left) || isSubPath(head, root.right));
    }

    @Test
    public void test03() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        System.out.println(isSubPath(head, root));

        head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        System.out.println(isSubPath(head, root));
    }
}
