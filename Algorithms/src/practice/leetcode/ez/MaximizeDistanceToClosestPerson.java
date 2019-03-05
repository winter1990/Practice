package practice.leetcode.ez;

/**
 * @array
 *
 * Return that maximum distance to closest person.
 *
 * count continuous number of 0s
 * if 0, then count++
 * if 1,
 */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int pos = -1;
        int count = 0, max = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (pos == -1) {
                    pos = 0;
                    max = i - pos;
                } else {
                    max = Math.max(max, (i - pos + 1) / 2);
                }
                pos = i + 1;
                count = 0;
            } else {
                count++;

            }
        }
        return max > count ? max : count;
    }

    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson md = new MaximizeDistanceToClosestPerson();
        int[] in = {0,1,1,0,0,0,0,0,1,0};
        System.out.println(md.maxDistToClosest(in));
    }
}
