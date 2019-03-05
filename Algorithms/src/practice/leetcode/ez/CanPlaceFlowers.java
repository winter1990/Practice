package practice.leetcode.ez;

/**
 * @array
 *
 * start from index 0. check left and right element, both need to be 0 then we can plan the flower
 * for each element, when 1 continue
 * if 0, then check left = i == 0 ? 0 : A[i-1], right = i == len - 1 ? 0 : A[i+1]
 * if both 0, mark it as 1, then continue
 * need to count how many flowers we have planted
 * at last check if count == n
 */
public class CanPlaceFlowers {
    // simplify the code and conditions
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 1) continue;
            int left = i == 0 ? 0 : flowerbed[i - 1];
            int right = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (left == 0 && right == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count == n;
    }

    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        } else if (n == 0) {
            return true;
        } else if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n <= 1;
        }
        int count = 0;
        int len = flowerbed.length;
        for (int  i = 0; i < len; i++) {
            if (i == 0) {
                if (flowerbed[i] != 1 && flowerbed[i + 1] == 0) count++;
                flowerbed[i] = 1;
            } else if (i == len - 1) {
                if (flowerbed[i] != 1 && flowerbed[len - 2] == 0) count++;
                flowerbed[i] = 1;
            } else {
                if (flowerbed[i] != 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }
}
