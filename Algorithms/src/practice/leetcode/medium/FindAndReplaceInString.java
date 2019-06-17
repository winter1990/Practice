package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 *
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones
 * (not necessarily the same size).
 *
 * need to sort the index first, otherwise, can not deal with the chars that no need to be replaced
 * create a new list of [indexes[i], i], index[0] is the actual index in string, index[1] is the index of src/target
 */
public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> indexList = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) indexList.add(new int[]{indexes[i], i});
        Collections.sort(indexList, (a, b) -> (a[0] - b[0]));
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for (int[] index : indexList) {
            int strIndex = index[0];
            int srcIndex = index[1];
            if (S.substring(strIndex).indexOf(sources[srcIndex]) == 0) {
                sb.append(S.substring(pre, strIndex));
                sb.append(targets[srcIndex]);
                pre = strIndex + sources[srcIndex].length();
            }
        }
        if (pre != S.length()) sb.append(S.substring(pre));
        return sb.toString();
    }

    public String findReplaceString1(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (S.startsWith(sources[i], indexes[i])) {
                map.put(indexes[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length();) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] ind = new int[]{0,2};
        String[] sr = new String[]{"a","cd"};
        String[] ta = new String[]{"eee","fff"};
        FindAndReplaceInString fa = new FindAndReplaceInString();
        System.out.println(fa.findReplaceString(s,ind, sr, ta));
    }
}
