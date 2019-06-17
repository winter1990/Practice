package practice.interview.google;

public class CountTargetInSortedArray {
    public int countNum(int[] arr, int target) {
        return count(arr, 0, arr.length - 1, target);
    }

    private int count(int[] arr, int s, int e, int target) {
        if (arr[s] == target && arr[e] == target) {
            return e - s + 1;
        } else if (target < arr[s] || target > arr[e]) {
            return 0;
        }
        int mid = s + (e - s) / 2;
        return count(arr, s, mid, target) + count(arr, mid + 1, e, target);
    }

    public static void main(String[] args) {
        int[] in = {1,2,4,6,6,6,7,9};
        CountTargetInSortedArray c = new CountTargetInSortedArray();
        System.out.println(c.countNum(in, 6));
    }
}
