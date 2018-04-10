package practice.interview.google;

/**
 * deck of cards
 * 1 - 10 J Q K
 *
 */
public class FullyDividedByK {
    public boolean fullyDivided(int[] arr, int k) {
        if (arr == null || arr.length % k != 0) {
            return false;
        }
        int n = arr.length;
        int[] frequency = new int[14];
        for (int i = 0; i < n; i++) {
            frequency[arr[i]]++;
        }
        int start = 1;
        while (start <= n - k) {
            if (frequency[start] != 0) {
                for (int i = 0; i < k; i++) {
                    frequency[start + i]--;
                    if (frequency[start + i] < 0) {
                        return false;
                    }
                }
            } else {
                start++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ar = {2,1,3,4,5,4,5,6,7,8,8,9,10,11,12};
        int k = 5;
        FullyDividedByK f = new FullyDividedByK();
        System.out.println(f.fullyDivided(ar, k));
    }
}
