package practice.leetcode.medium;

/**
 * @string
 *
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 * bulls - position & digit - A
 * cows - digit only - B
 *
 * 1870
 * 7810
 * checker[1]++
 * checker[7]--
 *
 * scan through the two strings
 * if s(i) == t(i) bulls++
 * for cows:
 *   numbers are range in [0,9] -> use map/int[10] to track occurrences
 *   for string s, checker[s[i]] < 0 cow++
 *   for string t, checker[t[i]] > 0 cow++
 *   checker[s[i]]++
 *   checker[t[i]]--
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] checker = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int i1 = secret.charAt(i) - '0';
            int i2 = guess.charAt(i) - '0';
            if (i1 == i2) {
                bulls++;
            } else {
                if (checker[i1] < 0) cows++;
                if (checker[i2] > 0) cows++;
                checker[i1]++;
                checker[i2]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
        String a = "1123";
        String b = "0111";
        System.out.println(bc.getHint(a, b));
    }
}
