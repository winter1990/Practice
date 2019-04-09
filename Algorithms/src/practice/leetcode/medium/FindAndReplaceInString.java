package practice.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        List<int[]> indexList = new LinkedList<>();
        for (int i = 0; i < indexes.length; i++) indexList.add(new int[]{indexes[i], i});
        Collections.sort(indexList, (a, b) -> (a[0] - b[0]));
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int[] index : indexList) {
            int strIndex = index[0];
            int sourceIndex = index[1];
            if (S.substring(strIndex).indexOf(sources[sourceIndex]) == 0) {
                sb.append(S.substring(last, strIndex));
                sb.append(targets[sourceIndex]);
                last = strIndex + sources[sourceIndex].length();
            }
        }
        if (last != S.length()) sb.append(S.substring(last));
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] ind = new int[]{0,2};
        String[] sr = new String[]{"ab","ec"};
        String[] ta = new String[]{"eee","fff"};
        FindAndReplaceInString fa = new FindAndReplaceInString();
        System.out.println(fa.findReplaceString(s,ind, sr, ta));
    }
}
