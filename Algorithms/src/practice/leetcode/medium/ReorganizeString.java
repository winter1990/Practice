package practice.leetcode.medium;

/**
 * @string
 *
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other
 * are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * int[26] -> scan the string and count the frequency -> use variable to track the largest -> compare with S.len
 * this method can only determine if string exists
 *
 * tweak this method a bit:
 * after getting all the frequency/occurrence of each character in string
 * aaaaabbbccc -> a.a.a.a.a.. -> abababa.a.. no working
 *                            -> a.a.a.a.a.b continue with b, ababa.a.a.b -> ababacacab
 *
 * start with even index, and continue with odd index
 * deal with the largest, second largest, third... -> need to order the frequency...
 * just need to arrange the largest first and then all the chars 1 by 1
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] freq = new int[26];
        int n = S.length(), max = 0;
        for (char c : S.toCharArray()) {
            ++freq[c - 'a'];
            if (freq[c - 'a'] > freq[max]) {
                max = c - 'a';
            }
        }
        if (freq[max] > (n + 1) / 2) return "";
        int index = 0;
        char[] res = new char[n];
        for (int i = 0 ; i < n; i+= 2) {
            if (freq[max] > 0) {
                res[i] = (char) ('a' + max);
                freq[max]--;
            } else {
                while (freq[index] == 0) index++;
                res[i] = (char) ('a' + index);
                freq[index]--;
            }
        }
        for (int i = 1; i < n; i+= 2) {
            while (freq[index] == 0) index++;
            res[i] = (char) ('a' + index);
            freq[index]--;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s = "snnnnbpngobwznvnnnlnwhvnnnnfjnnlnnnnnnbnknnqkndzefncknnnnnaiqrntnndnnnjninnnunnunqhndnnqnnsjqnnpiqshntnnncnvnnnncnnqenlnninyndnnnljongnnjwnnnngllnnngkbnllnnnnontlbpngjnnenqnsnnnnnjeqqghnfpngepnodnnnnnnvnsrnughbnipvnhqmnzonoonnnjotnnonoennnpnfnnkdnnbmnmnpnqninnxronnnnvnlanlnnnebnnnlnvnfknsnbincnttnmnguqenhnnxunnnntnnnnhnqnzehvunfnvnndvnjnnnbnnpxnqipwnmnonnndlnsnonnninnxnnnjnnnnnesennmyiednnnnnnnnnhimtnnnonjlicnwnwvnntaxmnrntnnnnsnbnanninnecbcfjxncnnkvnnqgnunensanpnngjnzxjnopnnyvnnxskniyytnsnnnnx";
        ReorganizeString r = new ReorganizeString();
        System.out.println(r.reorganizeString(s));
    }
}
