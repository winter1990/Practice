package practice.leetcode.medium;

import java.util.*;

/**
 * @array
 *
 * Input: [17,13,11,2,3,5,7], Output: [2,13,3,11,5,17,7]
 *
 * all of the cards are unique numbers
 * we actually pick the number one by one from a sorted array
 * for even number of elements
 * 0 1 2 3 4 5 6 7 8 9
 * . . . . . . . . . .
 * pick 0 1 2 3 4  array is 0.1.2.3.4. numbers left 5 6 7 8 9
 * pick 5 6 7      array is 051.263.47 numbers left 8 9
 * pick 8          array is 0518263.47 numbers left 9
 * 0519263847 -> 01234 58697 -> 567 98 -> 9 -> 8
 * for index:
 * 0 2 4 6 8, 1 5 9, 3, 7
 *
 * 012345678
 * 0.1.2.3.4    5678
 * 0.152.364    78
 * 0.1527364    8
 * 081527364 -> 01234 5768 -> 1234556 78 -> ...
 *
 */
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) q.offer(i);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.offer(q.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {0,1,2,3,4,5,6,7,8,9};
        RevealCardsInIncreasingOrder r= new RevealCardsInIncreasingOrder();
        r.deckRevealedIncreasing(in);
    }
}
