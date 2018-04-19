package practice.leetcode.hard;

/**
 * @array
 * @slidingWindow
 *
 * output in which day there exists two flowers in the status of blooming,
 * and also the number of flowers between them is k and these flowers are not blooming
 * If there isn't such day, output -1.
 *
 * [1,3,2], k = 1 -> 2 in day 2, first and third bloom and 3 in the middle is not
 *
 * sliding window?
 * The idea is to use an array days[] to record each position’s flower’s blooming day.
 * That means days[i] is the blooming day of the flower at position i+1.
 * [4 2 1 3], days = [3 2 4 1]
 * find a subarray of size k+2 so that for the array
 * [arr[i] arr[i+1]...arr[i+k] arr[i+k+1]], arr[i]<x, arr[i+k+1]<x
 *
 */
public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        // days[i] means at the i+1 day, the flower at the index days[i]-1 will bloom
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[flowers[i] - 1] = i + 1;
        }
        // boundary of sliding window
        int left = 0;
        int right = k + 1;
        int res = Integer.MAX_VALUE;
        int i = 1;
        while (right < n) {
            while (i < right && days[i] > days[left] && days[i] > days[right]) {
                i++;
            }
            if (i == right) {
                res = Math.min(res, Math.max(days[left], days[right]));
            }
            left = i;
            right = i + k + 1;
            i++;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
