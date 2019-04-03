package practice.leetcode.medium;

import java.util.*;

/**
 * @unionfind
 *
 * Two accounts definitely belong to the same person if there is some email that is common to both accounts.
 *
 * union find
 * person index is the index in array
 *
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) return res;
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                if (map.containsKey(acc.get(j))) {
                    int p = map.get(acc.get(j));
                    if (find(parent, p) != find(parent, i)) {
                        parent[find(parent, i)] = find(parent, p);
                    }
                } else {
                    map.put(acc.get(j), i);
                }
            }
        }

        Map<Integer, Set<String>> list = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int index = find(parent, i);
            if (!list.containsKey(index)) list.put(index, new HashSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) list.get(index).add(accounts.get(i).get(j));
        }

        for (int id : list.keySet()) {
            res.add(new ArrayList<>());
            res.get(res.size() - 1).add(accounts.get(id).get(0));
            List<String> emails = new ArrayList<>(list.get(id));
            Collections.sort(emails);
            res.get(res.size() - 1).addAll(emails);
        }
        return res;
    }

    private int find(int[] parent, int n) {
        if (parent[n] != n) {
            parent[n] = find(parent, parent[n]);
        }
        return parent[n];
    }

    public static void main(String[] args) {
        AccountsMerge ac = new AccountsMerge();
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        list.add(Arrays.asList("John", "johnnybravo@mail.com"));
        list.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        list.add(Arrays.asList("Mary", "mary@mail.com"));
        System.out.println(ac.accountsMerge(list));
    }
}
