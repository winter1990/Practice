package practice.leetcode.medium;

public class FindTheCelebrity {
}

/**
 * @array
 *
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them
 *
 * intuition:
 * for each person i
 *   check if everyone knows i
 * for i = [0, n - 1]
 *   for j = [0, n - 1] & j != i
 *     check if i knows j
 * count the number of people, map int int
 * one more pass to check if there one person with 0 value
 * O(N^2), O(N)
 *
 * optimization
 * temporary think about the candidate as 0
 * when we should change the candidate? when candidate knows someone else
 * i = [1, n - 1]
 *   if candidate knows i
 *     candidate = i
 * after this loop, we know the candidate does not know EVERYONE. suppose candidate is at i
 * [0 1 2 3 4 5 ... n]
 * all the people [0, i) will not be the celebrity
 * and i does not know anyone between [i + 1, n - 1]
 */

/* comment the code as the API not given and not defined
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }
}
*/