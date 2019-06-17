package practice.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * sorted, 有重复，有且仅有一个数字在数组里的数量超过了25%，找到这个数字
 *
 * 0 1 2 3 4 5 6 7 8  9 10 - 11 element
 * 0 1 2 4 5 8 8 8 9 10 11
 *
 */
public class FindElementMoreThan25Percent {
    public static void main(String[] args) {
        int[] in = {0,0,1,2,3,4,6};
        FindElementMoreThan25Percent f = new FindElementMoreThan25Percent();
        System.out.println(f.findElement(in));
    }

    public int findElement(int[] a) {
        int n = a.length;
        List<Integer> candidates = new ArrayList<>();
        candidates.add(searchElement(a, 0, n / 2));
        candidates.add(searchElement(a, n / 2 + 1, n - 1));
        candidates.add(searchElement(a, n / 4, 3 * n / 4));
        int res = 0;
        for (int c : candidates) {
            if (countElement(a, c) > n / 4) res = c;
        }
        return res;
    }

    private int countElement(int[] a, int target) {
        int searchLeft = findLeftIndex(a, target);
        int searchRight = findRightIndex(a, target);
        return searchRight - searchLeft + 1;
    }

    private int findLeftIndex(int[] a, int t) {
        int l = 0, r = a.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (t > a[mid]) {
                l = mid + 1;
            } else if (t < a[mid]) {
                r = mid - 1;
            } else {
                if (mid != 0 && a[mid] == a[mid - 1]) {
                    r = mid - 1;
                } else {
                    break;
                }
            }
        }
        return mid;
    }

    private int findRightIndex(int[] a, int t) {
        int l = 0, r = a.length - 1, mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (t > a[mid]) {
                l = mid + 1;
            } else if (t < a[mid]) {
                r = mid - 1;
            } else {
                if (a[mid] == a[mid + 1]) {
                    l = mid + 1;
                } else {
                    break;
                }
            }
        }
        return l;
    }
    private int searchElement(int[] a, int start, int end) {
        return a [(start + end) / 2];
    }
}
