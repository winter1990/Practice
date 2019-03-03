package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.List;

/**
 * @design
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 *
 */
public class DesignHashMap {
    public static void main(String[] args) {
        MyHashMap m = new MyHashMap();
        m.put(1,1);
        m.put(2,2);
        System.out.println(m.get(1));
        System.out.println(m.get(3));
        m.put(2,1);
        System.out.println(m.get(2));
        m.put(2,3);
        System.out.println(m.get(2));
        m.remove(2);
        System.out.println(m.get(2));
        m.put(2,4);
        System.out.println(m.get(2));
    }
}

/**
 * still do not know why it's wrong
 */
class MyHashMap {
    Node[] lists;
    int buckets = 10000;

    public MyHashMap() {
        lists = new Node[buckets];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int h = hash(key);
        if (lists[h] == null) {
            lists[h] = new Node(-1, -1);
        }
        Node pre = findNodeInBucket(lists[h], key);
        if (pre.next == null) {
            pre.next = new Node(key, value);
        } else {
            pre.next.val = value;
        }
    }

    private Node findNodeInBucket(Node node, int key) {
        Node pre = null;
        Node cur = node;
        while (cur != null && cur.key != key) {
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }

    private int hash(int key) {
        return key % buckets;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int h = hash(key);
        if (lists[h] == null) {
            return -1;
        }
        Node pre = findNodeInBucket(lists[h], key);
        if (pre.next == null) {
            return -1;
        }
        return pre.next.val;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int h = hash(key);
        if (lists[h] == null) {
            return;
        }
        Node pre = findNodeInBucket(lists[h], key);
        if (pre.next == null) {
            return;
        }
        pre.next = pre.next.next;
    }

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}