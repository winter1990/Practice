package practice.interview.google;

import java.util.*;

public class ChessHorseJumpWithoutObstacle {
    public List<List<String>> findShortestPath(String start, String end) {
        Map<String, List<String>> map = new HashMap<>();
        buildMap(start, end, map);
        List<String> list = new ArrayList<>();
        list.add(start);
        List<List<String>> res = new ArrayList<>();
        getPath(start, end, map, list, res);
        return res;
    }

    private void getPath(String begin, String end, Map<String, List<String>> map, List<String> list, List<List<String>> res) {
        if (begin.equals(end)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(begin)) return;
        for (String next : map.get(begin)) {
            list.add(next);
            getPath(next, end, map, list, res);
            list.remove(list.size() - 1);
        }
    }

    int[][] dirs = {{1, 2}, {-1, 2}, {-1, -2}, {1, -2}, {2, 1}, {-2, -1}, {-2, 1}, {2, -1}};
    private void buildMap(String begin, String end, Map<String, List<String>> map) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        boolean isBackward = false;
        beginSet.add(begin);
        endSet.add(end);
        boolean found = false;
        while (!beginSet.isEmpty() && !found) {
            if (beginSet.size() < endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
                isBackward = !isBackward;
            }
            Set<String> set = new HashSet<>();
            for (String s : beginSet) {
                visited.add(s);
                String[] p = s.split(" ");
                int r = Integer.valueOf(p[0]);
                int c = Integer.valueOf(p[1]);
                for (int[] d : dirs) {
                    int x = r + d[0];
                    int y = c + d[1];
                    String next = x + " " + y;
                    if (visited.contains(next) || beginSet.contains(next)) continue;
                    if (endSet.contains(next)) found = true;
                    set.add(next);
                    String from = isBackward ? next : s;
                    String to = isBackward ? s : next;
                    if (!isBackward) map.computeIfAbsent(from, a -> new ArrayList<>()).add(to);
                }
            }
            beginSet = set;
        }
    }

    public static void main(String[] args) {
        ChessHorseJumpWithoutObstacle c = new ChessHorseJumpWithoutObstacle();
        System.out.println(c.findShortestPath("0 0", "1 0"));
    }
}
