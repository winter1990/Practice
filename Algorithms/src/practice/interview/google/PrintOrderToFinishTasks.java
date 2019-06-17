package practice.interview.google;

import java.util.*;

/**
 * build level of depth - map
 * build the graph - map string set of strings for dependencies
 * level traversal - queue
 * start with level 0 - put in q
 * for each tasks in map, level--, if 0, add to queue
 */
public class PrintOrderToFinishTasks {
    public List<String> getOrderOfTasks(String[][] tasks) {
        Map<String, Integer> depth = new HashMap<>();
        Map<String, Set<String>> dependency = new HashMap<>();
        for (String[] p : tasks) {
            if (!dependency.containsKey(p[1])) dependency.put(p[1], new HashSet<>());
            dependency.computeIfAbsent(p[1], s -> new HashSet<>()).add(p[0]);
            depth.put(p[0], depth.getOrDefault(p[0], 0) + 1);
        }
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for (String t : dependency.keySet()) {
            if (depth.get(t) == 0) {
                q.offer(t);
                res.add(t);
            }
        }
        while (!q.isEmpty()) {
            String cur = q.poll();
            res.add(cur);
            for (String t : dependency.get(cur)) {
                depth.put(t, depth.get(t) - 1);
                if (depth.get(t) == 0) {
                    q.offer(t);
                }
            }
        }
        return res;
    }
}
