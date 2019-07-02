package practice.leetcode.easy;

import java.util.*;

/**
 * @design
 *
 * Write a class RecentCounter to count recent requests.
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 * method 1 - tree map
 * tree map
 *   key - time stamp
 *   value - number of calls
 * if empty map
 *   put entry (t,1)
 * otherwise
 *   put (t floor value +1)
 * return
 *   current - get ceiling value (t - 3000) + 1
 *
 * this method is inefficient because we have to store all the time stamp and number of calls
 * if over integer.max
 * or if duplicate calls for the same time stamp
 * it will be error
 *
 *
 * method 2 - list
 * still need to store all the time stamp
 * count the size and get the insertion position
 *
 * method 3 - queue
 * space and time efficient
 * take all the integers in the queue if q.peek() < t - 3000
 * return the size of queue
 */
public class NumberOfRecentCalls {
    class RecentCounter {
        TreeMap<Integer, Integer> map;

        public RecentCounter() {
            map = new TreeMap<>();
        }

        public int ping(int t) {
            if (map.size() == 0) {
                map.put(t, 1);
                return 1;
            }
            map.put(t, map.get(map.floorKey(t)) + 1);
            return map.get(t) - map.get(map.ceilingKey(t - 3000)) + 1;
//            map.put(t, 1 + tm.size());
//            return map.tailMap(t - 3000).size(); // also works
        }
    }

    class RecentCounter1 {
        List<Integer> list;
        public RecentCounter1() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            list.add(t);
            int i = Collections.binarySearch(list, t - 3000);
            if (i < 0) {
                i = -i - 1;
            }
            return list.size() - i;
        }
    }

    class RecentCounter2 {
        Queue<Integer> q;
        public RecentCounter2() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            while (!q.isEmpty()) {
                if (q.peek() < t - 3000) {
                    q.poll();
                } else {
                    break;
                }
            }
            q.offer(t);
            return q.size();
        }
    }
}