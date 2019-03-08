package practice.leetcode.ez;

/**
 * @design
 *
 * put(key, value) : Insert a (key, value) pair. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 *
 * key-value pair for put, get, update and remove
 * the key is to build up the pairing relationship. we need to initialize a number of buckets for the data structure
 * use hash code for the index -> suppose we have 10k buckets as number of entries increases, there might have collision
 * for one single bucket.
 * which bucket we choose to put the entry? hashcode % bucket#
 * to handle the collision, normally, use a linked list like data structure -> define list node, with key, value, next.
 * when check a bucket, if empty -> create new and put,
 * if not -> check node's key 1 by 1 -> if found, update, if no, new node to the tail
 * for the case of not found, we scan from the head and return null, but we need to add to tail, so scan again from head
 * also, if we want to remove some node, check if it's in the list first, also need to scan twice
 * one way to handle it is to add a dummy node as head -> check the next node -> (-1,-1) as all key are positive
 *
 * methods need to define and reuse:
 * getIndex(int)
 * give the head of a list of nodes, findNode(Node head, key)
 */
public class DesignHashMap {
}

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
            lists[h].next = new Node(key, value);
        } else {
            Node pre = findNodeInBucket(lists[h], key);
            if (pre.next != null) {
                pre.next.val = value;
            } else {
                pre.next = new Node(key, value);
            }
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
        return Integer.hashCode(key) % buckets;
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
