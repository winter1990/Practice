package practice.leetcode.medium;

/**
 * @array
 *
 * given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's
 * attacking, you need to output the total time that Ashe is in poisoned condition.
 *
 * translation:
 * the element in the array is the start time
 * duration is the length of interval
 * we want to get the total length
 *
 * [1 3] 3, [1 4] [3 6] -> [1 6]
 * pre (start time), last (max of pre + duration and next start) total
 *
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] t, int duration) {
        if (t == null || t.length == 0) return 0;
        int pre = t[0], cur = pre + duration, total = 0;
        for (int i = 1; i < t.length; i++) {
            if (t[i] > cur) {
                total += cur - pre;
                pre = t[i];
            }
            cur = t[i] + duration;
        }
        total += (cur - pre);
        return total;
    }
}
