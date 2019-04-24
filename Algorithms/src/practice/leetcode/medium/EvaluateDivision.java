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

    public double[] calcEquation1(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<String>> pairs = new HashMap<>();
        HashMap<String, List<Double>> valuesPair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<>());
                valuesPair.put(equation[0], new ArrayList<>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<>());
                valuesPair.put(equation[1], new ArrayList<>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            double val = dfs(queries[i][0], queries[i][1], pairs, valuesPair, new HashSet<>());
            result[i] = val == 0 ? -1 : val;
        }
        return result;
    }
    private double dfs(String s, String e, Map<String, List<String>> pairs, Map<String, List<Double>> values, HashSet<String> visited) {
        if (visited.contains(s)) return 0;
        if (!pairs.containsKey(s)) return 0;
        if (s.equals(e)) return 1;

        visited.add(s);
        for (int i = 0; i < pairs.get(s).size(); i++) {
            String next = pairs.get(s).get(i);
            if (visited.contains(next)) continue;
            double v = dfs(next, e, pairs, values, visited);
            if (v != 0) return v * values.get(s).get(i);
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
