package practice.leetcode.medium;

import java.util.*;

/**
 * @search
 * @graph
 *
 * build up the map
 * use map - string,queue
 * as lexical order, so use priority queue
 */
public class ReconstructItinerary {
    /*
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            res.add("");
            return res;
        }
        for (String[] ite : tickets) {
            if (!map.containsKey(ite[0])) {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.offer(ite[1]);
                map.put(ite[0], q);
            }
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String start) {
        PriorityQueue<String> pq = map.get(start);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        res.addFirst(start);
    }
    */

    /* dead end happens [a,d][a,f][f,a]
    private void dfs(String start, Map<String, PriorityQueue<String>> map, List<String> res) {
        String s = start;
        while (s != null) {
            res.add(s);
            if (map.containsKey(s)) {
                s = map.get(s).poll();
            } else {
                s = null;
            }
        }
    }
    */

    public static void main(String[] args) {
        String[][] in = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
                //{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        ReconstructItinerary r = new ReconstructItinerary();
        System.out.println(r.findItinerary(in));
    }

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
}
