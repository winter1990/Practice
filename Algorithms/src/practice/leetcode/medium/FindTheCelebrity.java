package practice.leetcode.medium;

public class FindTheCelebrity {
}

/**
 * everyone know him/her
 * he/she knows no one
 */

/* comment the code as the API not given and not defined
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 0) {
            return -1;
        }
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (knows(index, i)) {
                index = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != index && (knows(index, i) || !knows(i, index))) {
                return -1;
            }
        }
        return index;
    }
}
*/