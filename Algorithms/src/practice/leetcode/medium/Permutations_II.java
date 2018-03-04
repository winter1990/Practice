package practice.leetcode.medium;

import java.util.*;

/**
 * might contain duplicates
 *
 * [112]->[112][211][121]
 *
 * impact of the duplicates:
 * affect the insertion, while to skip
 */
public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
            for (List<Integer> l : res) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, nums[i]);
                    List<Integer> T = new LinkedList<>(l);
                    l.remove(j);
                    currentSet.add(T);
                }
            }
            res = new LinkedList<>(currentSet);
        }
        return res;
    }

    public static void main(String[] args) {
//        Permutations_II p = new Permutations_II();
//        int[] in = {1,2,2};
//        System.out.println(p.permuteUnique(in));

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        l1.add(1);
        l1.add(2);
        l2.add(1);
        l2.add(2);
        set.add(l1);
        set.add(l2);
        System.out.println(set);
    }
}
