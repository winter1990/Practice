package practice.leetcode.easy;

/**
 * @array
 *
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * There is at least one empty seat, and at least one person sitting.
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * translation:
 * count the continuous 0s, and deal with the leading and tailing 0s. return the distance
 * [0 0 1 0 1 0 0 0 0 0 1 0]
 * leading 0s: 2
 * tailing: 1
 * longest consecutive 0s: 4
 *
 * if 0, count++
 * if 1
 *   if it is the first 1, the position should be at 0, pos = 0, max = i - position
 *   else max = (max, (i - pos + 1) / 2)
 *   pos = i + 1
 */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int i = 0, j = 0, max = 0, n = seats.length;
        for (;j < n; j++) {
            if (seats[j] == 1) {
                if (i == 0) {
                    max = j - i;
                } else {
                    max = Math.max(max, (j - i + 1) / 2);
                }
                i = j + 1;
            }
        }
        max = Math.max(max, j - i);
        return max;
    }

    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson md = new MaximizeDistanceToClosestPerson();
        int[] in = {0,1,1,0,0,0,0,0,1,0};
        System.out.println(md.maxDistToClosest(in));
    }
}
