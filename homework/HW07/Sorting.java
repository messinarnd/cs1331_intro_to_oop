// I worked on this alone.

/**
* Collection of sorting algorithms for use in HW07 - Silicon Valley
* @version 1.0
* @author Christopher Messina
*/
public class Sorting {

    /**
    * Insertion Sort algorithm.
    * @param tenXers a Comparable array to be sorted
    */
    public static void insertionSort(Comparable[] tenXers) {
        for (int i = 1; i < tenXers.length; i++) {
            TenXer myVal = (TenXer) tenXers[i];
            int j = i - 1;
            while (j >= 0 && tenXers[j].compareTo(myVal) > 0) {
                tenXers[j + 1] = tenXers[j];
                j--;
            }
            tenXers[j + 1] = myVal;
        }
    }

    /**
    * The public method for the Merge Sort algorithm.
    * @param arr a Comparable array to be sorted
    */
    public static void mergeSort(Comparable[] arr) {
        if (arr.length == 1) {
            return;
        }
        Comparable[] temp = new Comparable[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(Comparable[] arr, Comparable[] temp,
            int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private static void merge(Comparable[] arr, Comparable[] temp,
            int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int leftNdx = low;
        int rightNdx = mid + 1;
        for (int k = low; k <= high; k++) {
            if (leftNdx > mid) {
                arr[k] = temp[rightNdx++];
            } else if (rightNdx > high) {
                arr[k] = temp[leftNdx++];
            } else if (temp[leftNdx].compareTo(temp[rightNdx]) <= 0) {
                arr[k] = temp[leftNdx++];
            } else {
                arr[k] = temp[rightNdx++];
            }
        }
    }
}