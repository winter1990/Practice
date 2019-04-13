package practice.leetcode.easy;

/**
 * @string
 *
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 *
 * Input: "IDID", Output: [0,4,1,3,2]
 * Input: "DDI", Output: [3,2,0,1]
 *
 * total length of result -> S.len + 1
 * 0 1 2 3 4
 * start from 0
 * if 'I', pick the smallest, to make sure no matter what, next value would be larger than last element
 * if 'D', pick the largest, so the next value would be smaller than last element
 *
 * suppose S.length = 4 and S="IDID", so the numbers we need to fill in the result set is 0 1 2 3 4
 * if the current char is 'I', we want to pick a number in the current potential options (0-4) that satisfies all scenarios in next loop, it should be the smallest one, which is 0
 * now the rest of options are 1 2 3 4
 * if the current char is 'D', again, we want to make sure that FOR EVERY NUMBER WE PICK IN NEXT ROUND will satisfy a[current] > a[current+1], then pick the largest value in 1 2 3 4, which is 4
 * then set becomes [1 2 3], we repeat the above
 * the thinking is really similar to "greedy" that we pick some number that can most satisfy the cases for next loop
 */
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int l = 0, r = S.length();
        for (int i = 0; i < S.length(); i++) {
            res[i] = S.charAt(i) == 'I' ? l++ : r--;
        }
        res[S.length()] = l;
        return res;
    }
}
