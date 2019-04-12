package practice.leetcode.medium;

/**
 * @array
 *
 * some/zero 0s followed by some/zero 1s
 * all 0s before 1s
 *
 * Input: "00110" Output: 1 -> 00122
 * Input: "010110" Output: 2 -> 011233
 * Input: "00011000" Output: 2 -> 00012222
 * Input: "00011000001" Output: 2 -> 00012222223
 * we want only one or none increasing array at the end
 *
 * total 1s
 * current 1s
 * start with index 0
 * option:
 *   flip all 0s after to 1
 *   flip all 1s before to 0
 * initially, all ones, so flip = min = zeros
 * i in [0,n-1], i represents partition index -> [0,i] (i,n-1]
 * initially, all 0s, so min = ones
 * for each element:
 *   if a[i] = 0, f0--
 *   if a[i] = 1, f1++
 *   min = (min, f1+f0)
 *
 */
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        int ones = 0, n = S.length();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '1') ones++;
        }
        int f0 = n - ones, f1 = 0, min = Math.min(ones, n - ones);
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if (c == '0') f0--;
            else f1++;
            min = Math.min(min, f1 + f0);
        }
        return min;
    }

    public int minFlipsMonoIncr1(String S) {
        if (S == null || S.length() <= 1) return 0;
        int n = S.length();
        int cntEndWithOne = 0, cntEndWithZero = 0;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            cntEndWithOne = Math.min(cntEndWithZero, cntEndWithOne) + (c == '1' ? 0 : 1);
            cntEndWithZero += (c - '0');
        }
        return Math.min(cntEndWithOne, cntEndWithZero);
    }

    public static void main(String[] args) {
        String s = "11001";
        FlipStringToMonotoneIncreasing f = new FlipStringToMonotoneIncreasing();
        System.out.println(f.minFlipsMonoIncr(s));
    }
}
