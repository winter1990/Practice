package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @string
 *
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 *
 * we can only swap chars at odd OR even index
 * they need to be tracked separately
 * freq of each char at odd even should be the same
 * use freq of odd/even as the string -> use set
 */
public class GroupsOfSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        if (A == null || A.length ==  0) return 0;
        Set<String> set = new HashSet<>();
        for (String a : A) {
            int[] even = new int[26];
            int[] odd = new int[26];
            for (int i = 0; i < a.length(); i++) {
                if (i % 2 == 0) {
                    even[a.charAt(i) - 'a']++;
                } else {
                    odd[a.charAt(i) - 'a']++;
                }
            }
            set.add(Arrays.toString(even) + Arrays.toString(odd));
        }
        return set.size();
    }
}
