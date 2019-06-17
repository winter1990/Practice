package practice.leetcode.medium;

import java.util.*;

/**
 * @search
 * @graph
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
 * read as a single string.
 *
 * problems to solve:
 * 1. build the map
 * 2. lexi order
 * 3. handle the dead end [a c][a b][c d][d a]
 *
 * build up the map
 *   one from may map to multiple destination and the destinations should be ordered by lexi, use a heap/pq
 *   string, pq
 * the itinerary should consists all the [from to] pair
 *
 * [a c][a b][c d][d a] -> [a c d a b]
 * a [b c]
 * c [d]
 * d [a]
 * if we start with [a b], there will be dead end and will not continue
 * however, this dead end path is valid and should be the end of the whole itinerary
 *
 * use greedy thinking to build the path backward, from tail to head
 *
 * keep building the path starting from first destination in heap until we reach the end of that sub-path
 * continue building the remaining sub-path and add it to the head of the main path
 * so, we are building the whole itinerary from the tail to head
 */
public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (!map.containsKey(from)) map.put(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", map, res);
        return res;
    }

    private void dfs(String from, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> toList = map.get(from);
        while (map.get(from) != null && map.get(from).size() > 0) {
            dfs(map.get(from).poll(), map, res);
        }
        res.addFirst(from);
    }
}
