package practice.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * [4 2 3]
 * [6 3][9]
 */
public class AllPossibleEquations {
    public List<Double> getAllEquations(int[] A) {
        List<Double> list = new ArrayList<>();
        for (int a : A) list.add((double) a);
        List<Double> res = new ArrayList<>();
        dfs(list, res);
        return res;
    }

    private void dfs(List<Double> list, List<Double> res) {
        if (list.size() == 1) {
            res.add(list.get(0));
            return;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            Double a = list.get(i);
            Double b = list.get(i + 1);
            List<Double> next = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (j == i || j == i + 1) continue;
                next.add(list.get(j));
            }
            for (double d : compute(a, b)) {
                next.add(i, d);
                dfs(next, res);
                next.remove(i);
            }
        }
    }

    private List<Double> compute(double a, double b) {
        List<Double> list = new ArrayList<>();
        list.add(a + b);
        list.add(a - b);
        list.add(a * b);
        if (b != 0) list.add(a / b);
        return list;
    }

    public static void main(String[] args) {
        int[] in = {4,2,3};
        AllPossibleEquations a = new AllPossibleEquations();
        System.out.println(a.getAllEquations(in));
    }
}
