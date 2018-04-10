package practice.interview.google;

/**
 * find an element that is the majority number in array
 * the same number is grouped together [1,1,3,3,3,3,2]
 * if does not exist, return ..
 *
 * the element in the middle
 */
public class MajorityOfElements {
    public int findMajority(int[] arr) {
        int n = arr.length;
        int target = arr[n / 2];
        int left = findLeft(arr, n, target);
        int right  = findRight(arr, n, target);
        if (right == -1 || (right - left + 1 <= n / 2)) {
            return Integer.MIN_VALUE;
        }
        return arr[n / 2];
    }

    private int findLeft(int[] arr, int n, int target) {
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target) {
                if (mid > 0 && arr[mid - 1] == target) {
                    e = mid - 1;
                } else {
                    return mid;
                }
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    private int findRight(int[] arr, int n, int target) {
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target) {
                if (mid < n - 1 && arr[mid + 1] == target) {
                    s = mid + 1;
                } else {
                    return mid;
                }
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MajorityOfElements m = new MajorityOfElements();
        int[] in1 = {1, 3, 3, 3, 2, 2};
        int[] in2 = {1, 3, 3, 3, 2, 2, 2};
        int[] in3 = {1, 3, 3, 3, 3, 2, 2};
        int[] in4 = {1,1,1,1,1,1, 3, 3, 3, 2, 2};
        int[] in5 = {1, 3, 3, 2, 2, 2, 2};
        System.out.println(m.findMajority(in1));
        System.out.println(m.findMajority(in2));
        System.out.println(m.findMajority(in3));
        System.out.println(m.findMajority(in4));
        System.out.println(m.findMajority(in5));
    }
}
