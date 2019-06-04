package practice.leetcode.medium;

import java.util.*;

/**
 * @search
 * @graph
 *
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * a / b = k is the path from a to b, the weight is k
 * then b to a is 1 / k
 * the query that consists of two nodes is the total weight from node1 to node2
 * build the graph:
 *   keep track of the weight from a node to all adjacent node
 *   one map tracks the values to all those nodes
 * dfs from start to end
 * if loop exists, a/b b/c c/a -> use set -> no result, return 0
 *
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            map.computeIfAbsent(eq[0], m -> new HashMap<>()).put(eq[1], values[i]);
            map.computeIfAbsent(eq[1], m -> new HashMap<>()).put(eq[0], 1 / values[i]);
        }
        int n = queries.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            double val = calculate(queries[i][0], queries[i][1], map, new HashSet<>());
            res[i] = val == 0 ? -1 : val;
        }
        return res;
    }

    private double calculate(String from, String to, Map<String, Map<String, Double>> map, HashSet<String> visited) {
        if (!map.containsKey(from)) return 0;
        if (from.equals(to)) return 1;
        visited.add(from);
        for (String next : map.get(from).keySet()) {
            if (visited.contains(next)) continue;
            double val = calculate(next, to, map, visited);
            if (val != 0) return val * map.get(from).get(next);
        }
        return 0;
    }

    // input param changed to list
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations.size() == 0) return new double[]{};
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            map.putIfAbsent(from, new HashMap<>());
            map.get(from).put(to, values[i]);
            map.putIfAbsent(to, new HashMap<>());
            map.get(to).put(from, 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            double val = findPath(map, from, to, new HashSet<>());
            res[i] = val == 0 ? -1 : val;
        }
        return res;
    }

    private double findPath(Map<String, Map<String, Double>> map, String from, String to, Set<String> visited) {
        if (!map.containsKey(from) || !map.containsKey(to)) return 0;
        if (from.equals(to)) return 1;
        visited.add(from);
        for (String next : map.get(from).keySet()) {
            if (!visited.contains(next)) {
                double val = findPath(map, next, to, visited);
                if (val != 0) return val * map.get(from).get(next);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[][] equations = { {"a", "b"}, {"b", "c"} };
        double[] values = {2.0, 3.0};
        String[][] queries = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
        EvaluateDivision ed = new EvaluateDivision();
        System.out.println(ed.calcEquation(equations, values, queries));
    }
}
