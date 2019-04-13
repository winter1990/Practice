package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @design
 *
 * To be specific, your design should include these functions:
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 * create an array of bucket, use hash code determine the index of bucket we want to store the value
 * need to define hash function -> int hash(int) {Integer.hashCode(int) % total#ofBucket}
 * because potential collision may happen, for each bucket we define it as List of integer
 * to add, get bucket # -> if null create a new list, if not check whether exist then add
 * remove, get bucket # -> check null bucket,
 */
public class DesignHashSet {

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.contains(1);
        set.contains(3);
        set.add(2);
        set.contains(2);
        set.remove(2);
        set.contains(2);
    }
}

class MyHashSet {
    List<Integer>[] lists;
    int buckets = 10000;
    /** Initialize your data structure here. */
    public MyHashSet() {
        lists = new LinkedList[buckets];
    }
    public int hash(int key) {
        return key % buckets;
    }

    public void add(int key) {
        int h = hash(key);
        if (lists[h] == null) {
            lists[h] = new LinkedList<>();
        }
        if (!lists[h].contains(key)) lists[h].add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        if (lists[h] != null && lists[h].contains(key)) {
            lists[h].remove(Integer.valueOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        if (lists[h] != null && lists[h].contains(key)) {
            return true;
        }
        return false;
    }

}
