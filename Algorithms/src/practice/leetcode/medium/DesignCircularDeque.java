package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class DesignCircularDeque {
}

class MyCircularDeque {
    List<Integer> list;
    int capacity;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        list = new ArrayList<>();
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (list.size() < capacity) {
            list.add(0, value);
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (list.size() < capacity) {
            list.add(value);
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (!list.isEmpty()) {
            list.remove(0);
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (list.size() == 0) {
            return -1;
        }
        return list.get(0);
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (list.size() == 0) {
            return -1;
        }
        return list.get(list.size() - 1);
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return list.size() == 0 ? true : false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return list.size() == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */