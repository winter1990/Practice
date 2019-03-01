package practice.leetcode.medium;

/**
 * @string
 *
 * the first problem we need to handle is out of bound condition
 * c - 'a'                      -> convert char to [0, 25]
 * c - 'a' + shift              -> shift right by shift[i]
 * (c - 'a' + shift) % 26       -> handle the char that larger than 'z'
 * (c - 'a' + shift) % 26 + 'a' -> convert it back to character from [a,z]
 *
 * the second problem we need to handle, number of shifts
 * for the last element, we shift by shift[n-1]
 * for second to last, sum up all the numbers after i
 * use a variable to sum up and added to current shift value
 * mod by 26
 */
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        char[] cs = S.toCharArray();
        int shift = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            cs[i] = (char)((cs[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(cs);
    }

    public String shiftingLetters1(String S, int[] shifts) {
        if (S.length() != shifts.length) {
            return S;
        }
        calculateShifts(shifts);
        char[] cs = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            int k = shifts[i] % 26;
            if (cs[i] - 'a' + shifts[i] > 25) {
                cs[i] = (char)('a' + ((cs[i] - 'a' + k) % 26));
            } else {
                cs[i] = (char)(cs[i] + k);
            }

        }
        return new String(cs);
    }

    private void calculateShifts(int[] shifts) {
        for (int i = 0; i < shifts.length; i++) {
            shifts[i] %= 26;
        }
        int total = 0;
        for (int shift : shifts) {
            total += shift;
        }
        for (int i = 0; i < shifts.length; i++) {
            int tmp = shifts[i];
            shifts[i] += (total - shifts[i]);
            total -= tmp;
        }
    }

    public static void main(String[] args) {
        ShiftingLetters sl = new ShiftingLetters();
        System.out.println(sl.shiftingLetters1("mkgfzkkuxownxvfvxasy", new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513}));
    }
}
