package practice.interview.google;

import java.util.*;

/**
 * input needed
 * List<List<Integer[]>> [from to cost],
 */
public class MinimumPathFromFirstToLastLayer {
    public int shortestPath(List<List<Integer[]>> networks, int[] nodeCost) {
        int floor = networks.size(); // floors
        Set<Integer>[] sets = new HashSet[floor];
        for (int i = 0; i < floor; i++) sets[i] = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int n = nodeCost.length;
        for (int i = 0; i < n; i++) map.put(i, new HashMap<>());
        for (int i = 0; i < floor; i++) {
            List<Integer[]> list = networks.get(i);
            for (Integer[] e : list) {
                sets[i].add(e[0]);
                sets[i].add(e[1]);
                map.get(e[0]).put(e[1], e[2]);
                map.get(e[1]).put(e[0], e[2]);
            }
        }
        for (int i = 0; i < floor - 1; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j : sets[i]) {
                if (!sets[i + 1].contains(j)) {
                    set.add(j);
                }
            }
            sets[i] = set;
        }
        Set<Integer[]>[] elevators = new HashSet[floor];
        for (int i = 0; i < floor; i++) elevators[i] = new HashSet<>();
        for (int i = 0; i < floor - 1; i++) {
            for (int node : sets[i]) {
                for (int next : map.get(node).keySet()) {
                    if (sets[i + 1].contains(next)) {
                        elevators[i].add(new Integer[]{node, next});
                    }
                }

            }
        }
        // int[] - [node id, flooor id, cost]
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<Integer> visited = new HashSet<>();
        for (Integer[] elev : elevators[0]) {
            int from = elev[0];
            int to = elev[1];
            q.offer(new int[]{to, 1, nodeCost[from] + map.get(from).get(to) + nodeCost[to]});
            visited.add(from);
        }
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curNode = cur[0], floorId = cur[1], cost = cur[2];
            visited.add(curNode);
            if (floorId == sets.length - 1) {
                min = Math.min(min, cost);
            }
            for (int nei : map.get(curNode).keySet()) {
                if (!visited.contains(nei)) {
                    if (floorId < floor - 1 && sets[floorId + 1].contains(nei)) {
                        q.offer(new int[]{nei, floorId + 1, cost + map.get(curNode).get(nei) + nodeCost[nei]});
                    } else {
                        q.offer(new int[]{nei, floorId, cost + map.get(curNode).get(nei) + nodeCost[nei]});
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer[]>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{0,1,2},new Integer[]{0,2,1},new Integer[]{1,2,2},new Integer[]{1,3,2}));
        list.add(Arrays.asList(new Integer[]{3,7,4},new Integer[]{3,6,1},new Integer[]{3,8,5},new Integer[]{6,7,2},new Integer[]{6,8,3},new Integer[]{7,4,1},new Integer[]{5,8,1}));
        list.add(Arrays.asList(new Integer[]{4,5,2},new Integer[]{5,9,2}));
        int[] c = {1,1,1,1,1,1,1,1,1,1};
        MinimumPathFromFirstToLastLayer m = new MinimumPathFromFirstToLastLayer();
        System.out.println(m.shortestPath(list, c));
    }
}
