package practice.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @string
 *
 * how to determine whether we should replace and index+source are both correct
 * get substring based on index value and check if indexOf substring is 0
 */
public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> indexList = new LinkedList<>();
        for (int i = 0; i < indexes.length; i++) {
            indexList.add(new int[]{indexes[i], i});
        }
        Collections.sort(indexList, (a, b) -> a[0] - b[0]);
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
        if (last != S.length()) {
            sb.append(S.substring(last));
        }
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
