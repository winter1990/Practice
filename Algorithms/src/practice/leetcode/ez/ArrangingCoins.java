package practice.leetcode.ez;

/**
 * @math
 * @search
 * linear is straightforward
 *
 * (1+x)x/2 <= n
 * find the largest x
 *
 * binary search
 * (1+mid)*mid/2 = n, mid
 * > n, e=mid-1
 * < n, s=mid+1
 *
 * while look - not exact value, use end as result
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        long start = 1;
        long end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long val = (1 + mid) * mid / 2;
            if (val == n) {
                return (int)mid;
            } else if (val > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int)end;
    }

    public static void main(String[] args) {
        ArrangingCoins ac = new ArrangingCoins();
        System.out.println(ac.arrangeCoins(1804289383));
//        System.out.println(ac.arrangeCoins(1));
//        System.out.println(ac.arrangeCoins(2));
//        System.out.println(ac.arrangeCoins(3));
//        System.out.println(ac.arrangeCoins(5));
//        System.out.println(ac.arrangeCoins(10));
    }
}
