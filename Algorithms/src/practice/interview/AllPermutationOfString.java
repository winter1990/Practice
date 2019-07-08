package practice.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * "" a b ab c ac bc abc
 *
 * what if duplicates
 *
 * aaabc
 * "" a aa aaa b ab aab aaab ....
 *
 * aba
 * "" a b ab aa ba aba
 */
public class AllPermutationOfString {
    public static List<String> getPermutation(String s) {
        List<String> res = new ArrayList<>();
        res.add("");
        getPerm(s, 0, res);
        res.remove("");
        return res;
    }

    private static void getPerm(String s, int index, List<String> res) {
        if (index == s.length()) return;
        int size = res.size();
        for (int i = 0 ; i < size; i++) {
            res.add(res.get(i) + s.charAt(index));
        }
        getPerm(s, index + 1, res);
    }

    public static List<String> permutations(String s) {
        List<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < s.length(); i++) {
            List<String> tmp = new ArrayList<>();
            for (String str : res) {
                tmp.add(str + s.charAt(i));
            }
            tmp.addAll(res);
            res = tmp;
        }
        return res;
    }
    public static void main(String[] args) {
//        System.out.println(permutations("abc"));
        System.out.println(getPermutation("abc"));
    }
}
