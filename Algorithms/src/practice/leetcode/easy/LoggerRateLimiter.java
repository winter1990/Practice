package practice.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoggerRateLimiter {
}

/**
 * @design
 *
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if
 * and only if it is not printed in the last 10 seconds.
 *
 * stream
 *   continuous input, and may call the method many times
 *   data size is large, maintain some ds
 * timestamp is increasing
 * multiple messages in the same time
 * we only want to store the logs within last 10 seconds and dump and ones over the time
 *
 * data structure to use
 *   maintain a data structure with size of 10 - array
 *   multiple logs in the same second - Set<String>
 *   Set<String>[10]
 *
 * if new log comes in to the system with the timestamp, we need to find which bucket we should:
 *   store
 *   look up
 * hashing mechanism -> index = timestamp % #numberOfBuckets
 * t   0 1 ...       ... 9
 * set[0 1 2 3 4 5 6 7 8 9]
 *
 * for the 10 buckets created
 *   index for the bucket - ts % 10
 *   set[index] is the bucket we should store the message
 * how to determine if it is timed out?
 *   need another array to store the ts
 *   [0 log1][0 log2][0 log3]... we store the ts 0 at 0%10 in the time array
 *   so when [10 log4] comes in, we can compare the previous ts with current
 *
 * if ts != times[index]
 *   clear the set as all of them timed out
 *   update the time[]
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
        for (int i = 0; i < sets.length; i++) sets[i] = new HashSet<>();
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