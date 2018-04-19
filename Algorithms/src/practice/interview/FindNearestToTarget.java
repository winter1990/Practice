package practice.interview;

/**
 * 给一串sorted数组和一个target，找数组里离target大小最近的数字。数组可能有重复的数字，如果是答案有不止一个，返回最小的那个坐标。
 * 用binary search就行，注意一下corner case
 */
public class FindNearestToTarget {
    public int findNearest(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        if (target <= arr[0]) {
            return 0;
        }
        if (target >= arr[n - 1]) {
            return findLeftMost(arr, 0, n - 1, arr[n - 1]);
        }
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target) {
                return findLeftMost(arr, s, mid, target);
            }
            if (arr[mid] > target) {
                if (mid > 0 && arr[mid - 1] < target && target < arr[mid]) {
                    return getClosest(arr, target, mid);
                }
                e = mid;
            } else {
                if (mid != n - 1 && arr[mid] < target && target < arr[mid + 1]) {
                    return getClosest(arr, target, mid + 1);
                }
                s = mid;
            }
        }
        return s;
    }

    private int getClosest(int[] arr, int target, int mid) {
        if (target - arr[mid - 1] < arr[mid] - target) {
            return mid - 1;
        }
        return mid;
    }

    private int findLeftMost(int[] arr, int s, int e, int target) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target) {
                if (mid != 0 && arr[mid] == arr[mid - 1]) {
                    e = mid - 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {1,1,1,1,1};int target = 3;
//        int[] arr = {1, 4, 4, 4, 5, 5, 6, 7};int target = 3;
        int[] arr = {1,2,2,2,2,3,3,4};int target = 5;

        FindNearestToTarget f = new FindNearestToTarget();
        System.out.println(f.findNearest(arr, target));
    }
}
