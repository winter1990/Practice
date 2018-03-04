package practice.leetcode.medium;

import java.util.*;

/**
 * use indexOf method, get substring, check indexOf again
 */
public class RepeatedDNASequences {
    // time limit exceeded
    public List<String> findRepeatedDnaSequences(String s) {
        int len = 10;
        List<String> res = new LinkedList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            if (s.indexOf(sub) >= 0) {
                if (s.substring(i + 1).indexOf(sub) >= 0) {
                    if (set.contains(sub)) {
                        continue;
                    } else {
                        res.add(sub);
                        set.add(sub);
                    }
                }
            } else {
                continue;
            }
        }
        return res;
    }

    public List<String> findRepeat(String s) {
        Set<String> set = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!set.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList(repeated);
    }

    public static void main(String[] args) {
        RepeatedDNASequences r = new RepeatedDNASequences();
//        System.out.println(r.findRepeatedDnaSequences("AAAAAAAAAA"));
        System.out.println(r.findRepeatedDnaSequences("AAAAAAAAAAAAAA"));
    }
}
