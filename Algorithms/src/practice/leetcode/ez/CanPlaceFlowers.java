package practice.leetcode.ez;

public class CanPlaceFlowers {
    // simplify the code and conditions
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len && count < n; i++) {
            if (flowerbed[i] == 1) continue;
            int next = i == len - 1 ? 0 : flowerbed[i + 1]; // cannot only check the index
            int last = i == 0 ? 0 : flowerbed[i - 1];
            if (last == 0 && next == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return n == count;
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
