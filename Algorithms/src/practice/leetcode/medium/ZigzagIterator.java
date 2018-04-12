package practice.leetcode.medium;

import java.util.*;

/**
 *
 */
public class ZigzagIterator {
    List<List<Integer>> list;
    int index;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index = 0;
        list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
    }

    public int next() {
        int value = 0;
        if (hasNext()) {
            value = list.get(index % 2).get(0);
            list.get(index % 2).remove(0);
            index++;
        }
        return value;
    }

    public boolean hasNext() {
        int cnt = 1;
        while (list.get(index % 2).isEmpty()) {
            index++;
            cnt++;
            if (cnt > list.size()) {
                return false;
            }
        }
        return true;
    }
}


class ZigzagIterator1 {
    LinkedList<Iterator> list;
    public ZigzagIterator1(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
