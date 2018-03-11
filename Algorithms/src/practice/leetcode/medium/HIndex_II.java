package practice.leetcode.medium;

/**
 * 0 1 3 5 6
 * 5 4 3 2 1
 *
 * 0 1 4 5 6
 * 5 4 3 2 1
 */
public class HIndex_II {
    // linear
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        } else if (citations.length == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        int n = citations.length;
        int i;
        for (i = 0; i < n; i++) {
            if ((i == 0 && citations[0] >= n - i) || (citations[i] >= n - i && (n - i >= citations[i - 1]))) {
                break;
            }
        }
        return n - i;
    }

    // binary search
    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int start = 0;
        int end = citations.length - 1;
        int n = citations.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] > n - mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return n - start;
    }
}
