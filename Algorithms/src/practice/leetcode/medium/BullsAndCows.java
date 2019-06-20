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
 * intuitive solution:
 *   define a counter for secret string
 *   scan from left to right and get the frequency for each digit in secret
 *   scan the guess string
 *     if a[i]=b[i], a bull is found
 *     else check if counter > 0
 * it is wrong because, we are matching bulls first and use the leftover chars to match the char in different location
 *
 * for different strings - secret and guess
 * i = [0, n-1]
 *   if s(i) == t(i) bulls++
 *   else
 *     use int[10] to track occurrences
 *     if checker[s[i]] < 0, it means there was s[i] in t before i, cow++
 *     if checker[t[i]] > 0, it means there was t[i] in s before i, cow++
 *     checker[s[i]]++
 *     checker[t[i]]--
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
}
