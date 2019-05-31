package practice.leetcode.easy;

/**
 * @array
 *
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * the third maximum here means the third maximum distinct number
 * define three Integer as null, m1 > m2 > m3
 *   if m1 null || n > m1, m3 = m2 m2 = m1 m1 = n
 *   else if m2 null || n > m2
 *   else if m3 null || n > m3
 * check m3 null or not
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer m1 = null;
        Integer m2 = null;
        Integer m3 = null;
        for (Integer n : nums) {
            if (n.equals(m1) || n.equals(m2) || n.equals(m3)) continue;
            if (m1 == null || n > m1) {
                m3 = m2;
                m2 = m1;
                m1 = n;
            } else if (m2 == null || n > m2) {
                m3 = m2;
                m2 = n;
            } else if (m3 == null || n > m3) {
                m3 = n;
            }
        }
        return m3 == null ? m1 : m3;
    }
}
