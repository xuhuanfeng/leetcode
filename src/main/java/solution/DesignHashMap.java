package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-27 6:50
 * @see <a href="https://leetcode.com/problems/design-hashmap/">706. Design HashMap</a>
 */
public class DesignHashMap {

    @Test
    public void tes01() {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 1);
        obj.put(2, 2);
        assertEquals(1, obj.get(1));
        assertEquals(-1, obj.get(3));
        obj.put(2, 1);
        assertEquals(1, obj.get(1));
        obj.remove(2);
        assertEquals(-1, obj.get(2));
        obj.put(1024, 100);
        assertEquals(100, obj.get(1024));
        obj.put(2048, 200);
        assertEquals(200, obj.get(2048));
        obj.put(4096, 300);
        assertEquals(300, obj.get(4096));

        obj.remove(4096);
        assertEquals(-1, obj.get(4096));

    }
}

class MyHashMap {

    class Node {
        public int key;
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
        }
    }

    private Node[] data;
    private static final int SIZE = 1024;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        data = new Node[SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int bucket = key % SIZE;
        Node head = data[bucket];
        while (head != null) {
            if (head.key == key) {
                head.val = value;
                return;
            }
            head = head.next;
        }
        Node node = new Node(key, value);
        node.next = data[bucket];
        data[bucket] = node;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int bucket = key % SIZE;
        Node head = data[bucket];
        while (head != null && head.key != key) {
            head = head.next;
        }
        return head == null ? -1 : head.val;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int bucket = key % SIZE;
        Node head = data[bucket];
        if (head != null) {
            if (head.key == key) {
                data[bucket] = head.next;
            } else {
                while (head.next != null) {
                    if (head.next.key == key) {
                        head.next = head.next.next;
                        break;
                    } else {
                        head = head.next;
                    }
                }
            }
        }
    }
}
