package practice.leetcode.easy;

/**
 * @array
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers
 * cannot be planted in adjacent plots
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 *
 * start from index 0. check left and right element, both need to be 0 then we can plan the flower
 * for each element, when 1 continue
 * if 0, then check left = i == 0 ? 0 : A[i-1], right = i == len - 1 ? 0 : A[i+1]
 * if both 0, mark it as 1, then continue
 * need to count how many flowers we have planted
 * at last check if count == n
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length, count = 0;
        for (int i = 0; i < m && count < n; i++) {
            if (flowerbed[i] == 1) continue;
            int left = i == 0 ? 0 : flowerbed[i - 1];
            int right = i == m - 1 ? 0 : flowerbed[i + 1];
            if (left == 0 && right == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count == n;
    }
}
