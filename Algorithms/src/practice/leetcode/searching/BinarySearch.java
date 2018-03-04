package practice.leetcode.searching;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) { // must be <=, otherwise there will be an element missed check
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 5, 6, 9, 10, 12, 14, 16, 20};
        int arr2[] = {1, 3};
        int ans1 = binarySearch(arr1, 10);
        int ans2 = binarySearch(arr2, 3);

        System.out.println(ans1);
        System.out.println(ans2);
    }
}
