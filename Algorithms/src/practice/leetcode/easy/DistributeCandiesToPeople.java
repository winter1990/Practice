package practice.leetcode.easy;

/**
 * @array
 *
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to
 * the last person.
 *
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second
 * person, and so on until we give 2 * n candies to the last person.
 *
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach
 * the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily
 * one more than the previous gift).
 *
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 */
public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        if (num_people == 1) {
            res[0] = candies;
            return res;
        }
        int c = 1;
        a:
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies >= c) {
                    candies -= c;
                    res[i] += c;
                } else {
                    res[i] += candies;
                    break a;
                }
                c++;
            }
        }
        return res;
    }

    public int[] distributeCandies1(int candies, int num_people) {
        int[] res = new int[num_people];
        int count = 0;
        for (; candies > 0; candies -= count) {
            res[count % num_people] += Math.min(++count, candies);
        }
        return res;
    }
}
