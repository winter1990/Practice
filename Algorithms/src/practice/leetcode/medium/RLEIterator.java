package practice.leetcode.medium;

/**
 * @array
 *
 * for all even i, A[i] tells us the number of times that the non-negative integer value A[i+1] is repeated in the sequence
 * A = [3,8,0,9,2,5], which is a run-length encoding of the sequence [8,8,8,5,5]
 * .next(2) exhausts 2 terms of the sequence, returning 8.  The remaining sequence is now [8, 5, 5].
 * .next(1) exhausts 1 term of the sequence, returning 8.  The remaining sequence is now [5, 5].
 * .next(1) exhausts 1 term of the sequence, returning 5.  The remaining sequence is now [5].
 * .next(2) exhausts 2 terms, returning -1.
 *
 * use an array list to store the changed array, and every time we cann next, remove n elements from the head
 * then get the first element
 *
 * we can also use constant space, the index start with 0
 */
public class RLEIterator {
    int[] a;
    int index;
    public RLEIterator(int[] A) {
        this.a = A;
        index = 0;
    }

    public int next(int n) {
        while (index < a.length && a[index] < n) {
            n -= a[index];
            index += 2;
        }
        if (index >= a.length) return -1;
        a[index] -= n;
        return a[index + 1];
    }
}

