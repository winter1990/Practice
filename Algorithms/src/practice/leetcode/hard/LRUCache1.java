package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {
    int currentSize;
    int capacity;
    Entry head;
    Entry tail;
    Map<Integer, Entry> map;
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        Entry entry = map.get(key);
        if (entry == null) {
            return -1;
        }
        moveEntryToHead(entry);
        return entry.value;
    }
    // exist - update, not exist - create new
    public void put(int key, int value) {
        Entry entry = map.get(key);
        if (entry == null) {
            if (currentSize >= capacity) {
                map.remove(tail.key);
                removeTail();
            } else {
                currentSize++;
            }
            entry = new Entry();
        }
        if (currentSize == 1) {
            head = entry;
            tail = entry;
        }
        entry.key = key;
        entry.value = value;
        moveEntryToHead(entry);
        map.put(key, entry);
    }
    // head tail null, check prev, if head already, or in the middle
    private void moveEntryToHead(Entry entry) {
        if (head == null) {
            head = entry;
            tail = entry;
            return;
        }
        if (entry == head) {
            return;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry == tail) {
            tail = entry.pre;
        }
        if (head != null) {
            entry.next = head;
            head.pre = entry;
        }
        head = entry;
        entry.pre = null;
    }

    private void removeTail() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail.pre.next = null;
        tail = tail.pre;
    }

    public static void main(String[] args) {
        LRUCache1 cache1 = new LRUCache1(2);
        cache1.put(1,1);
        cache1.put(2,2);
        cache1.get(1);
        cache1.put(3,3);
        cache1.get(2);
        cache1.put(4,4);
        cache1.get(1);
        cache1.get(3);
        cache1.get(4);
    }
}
