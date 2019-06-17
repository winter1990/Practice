package practice.interview;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationsFromTo {
    public List<List<String>> getAllPaths(List<Pair> list) {
        List<List<String>> res = new ArrayList<>();
        int total = list.size() * 2;
        int[] checker = new int[list.size()];
        dfs(total, checker, list, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int total, int[] checker, List<Pair> list, List<String> path, List<List<String>> res) {
        if (path.size() == total) res.add(new ArrayList<>(path));
        for (int i = 0; i < list.size(); i++) {
            if (checker[i] == 0) {
                checker[i]++;
                path.add(list.get(i).from);
                dfs(total, checker, list, path, res);
                checker[i]--;
                path.remove(path.size() - 1);
            } else if (checker[i] == 1) {
                path.add(list.get(i).to);
                checker[i]++;
                dfs(total, checker, list, path, res);
                path.remove(path.size() - 1);
                checker[i]--;
            } else {
                continue;
            }
        }
    }

    static class Pair {
        String from;
        String to;
        public Pair(String f, String t) {
            from = f;
            to = t;
        }
    }

    public static void main(String[] args) {
        Pair p1 = new Pair("ap","bd");
        Pair p2 = new Pair("bp","ad");
        List<Pair> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        AllCombinationsFromTo a = new AllCombinationsFromTo();
        System.out.println(a.getAllPaths(list));
    }
}
