package practice.leetcode.hard;

import java.util.*;

/**
 * @design
 *
 * Least Recently Used - make sure the algorithm always discards the least recently used item
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * for cache, we have limited size
 * keep track of the current number of entries
 * for each entry - we have key, value and the reference for next, previous -> like a double linked list
 *
 * when we get the entry, two cases: 1. not exists in cache, do nothing; 2. exists and we move it at the head as recent used
 *
 * when we put new entry in the cache,two cases: 1. exist; 2. non-exist
 * to check whether exists, get from map -> it can be null or we get the existing entry
 * if null, add a new to the head, update head (head can be null also, head and tail will be new entry)
 * also need to check the size every time we add a new entry, if current size >= capacity, remove and update tail
 *
 * always keep in mind all the parameters and whether reference of pre and next is null
 * always manage to update the head and tails - check whether null or need to be updated
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Entry> nodes;
    private int currentSize;
    private Entry first;
    private Entry last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        nodes = new HashMap<>();
    }

    public int get(int key) {
        Entry node = nodes.get(key);
        if(node != null){
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Entry node = nodes.get(key);
        if(node == null){
            if(currentSize >= capacity){
                nodes.remove(last.key);
                removeLast();
            } else {
                currentSize++;
            }
            node = new Entry();
        }
        if(currentSize == 1){
            first = node;
            last = node;
        }
        node.key = key;
        node.value = value;
        moveToHead(node);
        nodes.put(key, node);
    }

    private void put1(int key, int value) {
        Entry entry = nodes.get(key);
        if (entry == null) {
            entry = new Entry();
            if (first == null) {
                last = entry;
            } else {
                entry.next = first;
                first.pre = entry;
            }
            first = entry;
            currentSize += 1;
            if (currentSize > capacity) {
                nodes.remove(last.key);
                removeLast();
            }
            nodes.put(key, entry);
        } else {
            moveToHead(entry);
            first = entry;
        }
        entry.key = key;
        entry.value = value;
    }

    private void moveToHead(Entry node){
        if (node == first) {
            return;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }

        if(last == node){
            last = node.pre;
        }

        if(first != null){
            node.next = first;
            first.pre = node;
        }
        first = node;
        node.pre = null;

    }

    private void removeLast(){
        if(last != null){
            if(last.pre != null){
                last.pre.next = null;
            } else {
                first = null;
            }
            last = last.pre;
        }
    }

    class Entry {
        Entry pre;
        Entry next;
        int key;
        int value;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put1(2,1);
        cache.put1(2,2);
        System.out.println(cache.get(2));
        cache.put1(3,3);
        System.out.println(cache.get(2));
    }
}

