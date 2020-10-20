package array_prac;

import java.util.Arrays;

public class QuickSort {

    static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            quicksort(arr, low, mid);
            quicksort(arr, mid + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;

        while (i < j) {
            while (i < high && arr[i] <= pivot) i++;
            while (j > low && arr[j] >= pivot) j--;
            if (i < j) swap(arr, i, j);
        }

        swap(arr, low, j);
        return j;
    }

    /**
     * Problem of this partition is that if the List already sorted we will get the 
     * runtime complexity as O(n^2) because the pivot always is the first element of the list
     * 
     * Solution: (it will mostly be O(n log n)
     * - select middle item as pivot
     * - randomly select pivot
     */
    static void quicksort2(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0 || low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;
 
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quicksort2(arr, low, j);
 
		if (high > i)
			quicksort2(arr, i, high);
	}

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 10, 10, 9, 12, 4, 33, 21, 8, 6, 10, 25,2,7,7 };
        int[] arr3 = { 2, 5, 7, 10, 10, 9, 12, 4, 33, 21, 8, 6, 10, 25,2,7,7 };
        int[] arr2 = {5, 1, 4, 6, 1, 3};
        int[] arr4 = {5, 1, 4, 6, 1, 3};
        System.out.println("before: ");
        System.out.println(Arrays.toString(arr));
        quicksort(arr);
        quicksort2(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr3));
        System.out.println("before: ");
        System.out.println(Arrays.toString(arr2));
        quicksort(arr2);
        quicksort2(arr4, 0, arr4.length - 1);
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr4));
    }
}
