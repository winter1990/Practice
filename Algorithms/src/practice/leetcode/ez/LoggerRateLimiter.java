package practice.leetcode.ez;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoggerRateLimiter {
}

/**
 * @design
 *
 * stream -> continuous input, and many calls
 * timestamp is increasing
 * use a map to store the message and last time the message is logged
 * we want to count only store last 10, and dump the ones over 10 seconds
 *
 * as multiple message might come in at the same time - Set[] size of 10
 * use an array[10] to store the time
 * thinking is hashing -> index = timestamp % 10
 * t   0 1 ...       ... 9
 * set[0 1 2 3 4 5 6 7 8 9]
 * if timestamp != times[index] timeout -> clear the set
 * times[i]=ts
 * scan through the times and if (ts-times[i]) < 10, check if exists in the set
 * add to set
 */

class Logger {
    int[] times;
    Set<String>[] sets;
    /** Initialize your data structure here. */
    public Logger() {
        times = new int[10];
        sets = new Set[10];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int index = timestamp % 10;
        if (timestamp != times[index]) {
            sets[index].clear();
            times[index] = timestamp;
        }
        for (int i = 0; i < sets.length; i++) {
            if (timestamp - times[i] < 10) {
                if (sets[index].contains(message)) return false;
            }
        }
        sets[index].add(message);
        return true;
    }
}

class Logger1 {
    /** Initialize your data structure here. */
    Map<String, Integer> map;
    public Logger1() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}