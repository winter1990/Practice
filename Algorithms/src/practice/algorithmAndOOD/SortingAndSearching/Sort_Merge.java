package practice.algorithmAndOOD.SortingAndSearching;

public class Sort_Merge {
    public void mergeSort(int[] arr) {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] helper, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSort(arr, helper, lo, mid);
            mergeSort(arr, helper, mid + 1, hi);
            merge(arr, helper, lo, mid, hi);
        }
    }

    private void merge(int[] arr, int[] helper, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            helper[i] = arr[i];
        }
        int helperLeft = lo;
        int helperRight = mid + 1;
        int cur = lo;
        while (helperLeft <= mid && helperRight <= hi) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[cur] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[cur] = helper[helperRight];
                helperRight++;
            }
            cur++;
        }
        int remain = mid - helperLeft;
        for (int i = 0; i <= remain; i++) {
            arr[cur + 1] = helper[helperLeft + i];
        }
    }
}
