package practice.leetcode.ez;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @string
 *
 * scan the string, and use a checker to find bold chars
 * when add left tag -> checker[i] && (i== 0 || !checker[i-1])
 * when add right tag -> checker[i] && (i == len - 1 || !checker[i+1])
 */
public class BoldWordsInString {
    public String boldWords(String[] words, String S) {
        if (words == null || words.length == 0) {
            return S;
        }
        boolean[] checker = new boolean[S.length()];
        for (String s : words) {
            check(checker, S, s);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (checker[i] && (i == 0 || !checker[i - 1])) {
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if (checker[i] && (i == S.length() - 1 || !checker[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

    private void check(boolean[] checker, String s, String word) {
        for (int i = 0; i <= s.length() - word.length(); i++) {
            String sub = s.substring(i, i + word.length());
            if (sub.equals(word)) {
                for (int j = i; j < i + word.length(); j++) {
                    checker[j] = true;
                }
            }
        }
    }

    // time limit exceeded
    /**
     * ["ab", "bc"],"aabcd"->"a<b>abc</b>d"
     * a<b>abc</b>de<b>ab</b>
     *
     * multiple substring exist
     * get index,indexOf(String,start index)
     * map<start index,length>
     *
     * store as range collection,{{},{},{}} merge and get result
     */
    public String boldWords1(String[] words, String S) {
        if (words == null || words.length == 0) {
            return S;
        }
        List<int[]> list = new LinkedList<>();
        for (String word : words) {
            int i = S.indexOf(word);
            if (i >= 0) {
                while (i + word.length() <= S.length() && S.substring(i).indexOf(word) >= 0) {
                    int[] range = new int[2];
                    range[0] = i + S.substring(i).indexOf(word);
                    range[1] = i + S.substring(i).indexOf(word) + word.length() - 1;
                    list.add(range);
                    i += 1;
                }
            }
        }
        if (list.size() == 0) return S;
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> l = new LinkedList<>();
        int[] pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int[] cur = list.get(i);
            if (cur[0] > pre[1] + 1) {
                l.add(pre);
                pre = cur;
            } else {
                pre[1] = Math.max(pre[1], cur[1]);
            }
        }
        l.add(pre);

        StringBuilder sb = new StringBuilder();
        int i = 0;

        for (int[] interval : l) {
            sb.append(S.substring(i, interval[0]));
            sb.append("<b>");
            sb.append(S.substring(interval[0], interval[1] + 1));
            sb.append("</b>");
            i = interval[1] + 1;
        }
        sb.append(S.substring(l.get(l.size() - 1)[1] + 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        BoldWordsInString bw = new BoldWordsInString();
        String s = "cbccceeead";
        String[] ss = {"e","cab","de","cc","db"};
        System.out.println(bw.boldWords(ss, s));
        System.out.println("cb<b>ccceee</b>ad");
    }
}
