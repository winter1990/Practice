package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * bulls - position & digit - A
 * cows - digit only - B
 * case 1: 1807 7810 -> 1A3B
 * case 2: 1123 0111 -> 1A1B
 * use map to track num&pos 1,01 2,3 3,3
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
