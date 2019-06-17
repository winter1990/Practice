package practice.interview.google;

/**
 * triangle array 定义为先上升，后下降的array, 比如 [1 3 5 4 2]， array 里面没有重复元素，
 * 1. 找出最大元素的坐标。2. 把这个数组排序。
 */
public class FindMaximumValueInTriangleArray {
    public int findMax(int[] a) {
        if (a == null || a.length < 3) return Integer.MIN_VALUE;
        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] > a[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] in = {-1,0,1,3,2};
        FindMaximumValueInTriangleArray f = new FindMaximumValueInTriangleArray();
        System.out.println(f.findMax(in));
    }

    public int[] sortTriangleArray(int[] a) {
        int[] res = new int[a.length];
        int l = 0, r = a.length - 1, index = 0;
        while (l <= r) {
            if (a[l] < a[r]) {
                res[index++] = a[l++];
            } else {
                res[index++] = a[r--];
            }
        }
        return res;
    }
}
