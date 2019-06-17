package practice.interview.google;

import java.util.*;

/**
 * 号码从0-N， 分派号码的时候有的数字是6， 可以拿成9， 要加一个下加线， 知道具体是6还是9， 比如10， 反过来是01， 就是invalid
 *
 * 0 1 (2 3 4 5) 6 (7) 8 9
 * 6 9 10 16 18 19 60 61 66 68 69 80 81 86 89 90 91 96 98 99 100
 * 1 digit - 6 9
 * >1 digits - contains any of 0 1 6 8 9, except all 8
 */
public class UnderscoreNumber {
    public List<Number> getAllNum(int n) {
        List<Number> res = new ArrayList<>();
        for (int val = 1; val <= n; val++) {
            Number num = new Number(val);
            if (shouldAddUnderscore(val)) {
                num.isUnderscored = true;
            }
            res.add(num);
        }
        return res;
    }

    public boolean shouldAddUnderscore(int n) {
        if (n == 6 || n == 9) return true;
        Set<Integer> set = new HashSet<>();
        Set<Integer> nums = new HashSet<>();
        set.addAll(Arrays.asList(0, 1, 6, 8, 9));
        while (n != 0) {
            if (!set.contains(n % 10)) return false;
            nums.add(n % 10);
            n /= 10;
        }
        if ((nums.contains(8) || nums.contains(1)) && nums.size() == 1) return false;
        return true;
    }

    class Number {
        int val;
        boolean isUnderscored;
        public Number(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        UnderscoreNumber u = new UnderscoreNumber();
        List<Number> res = u.getAllNum(100);
        for (int i = 0; i < res.size(); i++) System.out.println(res.get(i).val + " " + res.get(i).isUnderscored);
    }
}
