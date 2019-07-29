package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-07-29 11:55
 * @see <a href="https://leetcode.com/problems/design-hashset/">705. Design HashSet</a>
 */
public class DesignHashSet {
    class MyHashSet {

        class Node {
            public int key;
            public Node next;

            public Node(int key) {
                this.key = key;
            }
        }

        private static final int SIZE = 1024;
        private Node[] data;

        /**
         * Initialize your data structure here.
         */

        private int getHash(int key) {
            return key % SIZE;
        }

        public MyHashSet() {
            data = new Node[SIZE];
        }

        public void add(int key) {
            int hash = getHash(key);
            Node head = data[hash];
            while (head != null) {
                if (head.key == key) {
                    return;
                }
                head = head.next;
            }
            head = new Node(key);
            head.next = data[hash];
            data[hash] = head;
        }

        public void remove(int key) {
            int hash = getHash(key);
            Node head = data[hash];
            if (head == null) {
                return;
            }
            if (head.key == key) {
                data[hash] = head.next;
                return;
            }
            while (head.next != null) {
                if (head.next.key == key) {
                    head.next = head.next.next;
                    return;
                }
                head = head.next;
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int hash = getHash(key);
            Node head = data[hash];
            while (head != null) {
                if (head.key == key) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }
    }

    @Test
    public void test01() {
        MyHashSet set = new MyHashSet();
        set.add(123);
        assertTrue(set.contains(123));
        set.remove(123);
        assertFalse(set.contains(123));
        set.add(1024);
        set.add(2048);
        set.add(4096);
        assertTrue(set.contains(1024));
        assertTrue(set.contains(2048));
        assertTrue(set.contains(4096));
        set.remove(4096);
        assertTrue(set.contains(2048));
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}

