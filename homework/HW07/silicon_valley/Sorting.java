/**
* Collection of sorting algorithms for use in HW07 - Silicon Valley
* @version 1.0
* @author Christopher Messina
*/
public class Sorting {

    public static void insertionSort(Comparable[] tenXers) {
        for (int i = 1; i <= tenXers.length; i++) {
            TenXer myVal = tenXers[i];
            int j = i - 1;
            while (tenXers[j].compareTo(myVal) > 0) {
                tenXers[j + 1] = tenXers[j];
                j--;
            }
            tenXers[j + 1] = myVal;
        }
    }

    public static void mergeSort(Comparable[] arr) {
        Comparable[] temp = new Comparable[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(Comparable[] arr, Comparable[] temp,
            int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid+1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private static void merge(Comparable[] arr, Comparable[] temp,
            int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[k] = arr[k];
        }

        int leftNdx = low;
        int rightNdx = mid + 1;
        for (int k = low; k <= high; k++) {
            if (leftNdx > mid) {
                temp[k] = arr[rightNdx++];
            } else if (rightNdx > high) {
                temp[k] = arr[leftNdx++];
            } else if (arr[leftNdx].compareTo(arr[rightNdx]) <= 0) {
                temp[k] = arr[leftNdx++];
            } else {
                temp[k] = arr[rightNdx++];
            }
        }
    }
}