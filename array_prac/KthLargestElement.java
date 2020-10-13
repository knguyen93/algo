package array_prac;

/**
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Your KthLargest class will have a constructor which accepts an integer k and
 * an integer array nums, which contains initial elements from the stream. For
 * each call to the method KthLargest.add, return the element representing the
 * kth largest element in the stream.
 * 
 * Example:
 * 
 * int k = 3; int[] arr = [4,5,8,2]; 
 * KthLargest kthLargest = new KthLargest(3, arr); 
 * kthLargest.add(3); // returns 4 
 * kthLargest.add(5); // returns 5
 * kthLargest.add(10); // returns 5 
 * kthLargest.add(9); // returns 8
 * kthLargest.add(4); // returns 8
 */
public class KthLargestElement {
  int k;
  int[] arr;

  public KthLargestElement(int k, int[] nums) {
    this.k = k;
    arr = nums;

    // sorting
    for (int i = 0; i < arr.length; i++) {
      int sm = i;
      for (int x = i + 1; x < arr.length; x++) {
        if (arr[sm] > arr[x]) {
          sm = x;
        }
      }

      if (sm != i) {
        int temp = arr[i];
        arr[i] = arr[sm];
        arr[sm] = temp;
      }
    }
  }

  public int add(int val) {
    int[] temp = new int[arr.length + 1];
    int i = 0;
    boolean found = false;

    // copy and insert new val
    while (i < arr.length) {
      if (found) {
        // if found then insert with extra index count
        temp[i + 1] = arr[i];
        i++;
      } else if (arr[i] < val) {
        temp[i] = arr[i];
        i++;
      } else {
        temp[i] = val;
        found = true;
      }
    }

    if (!found)
      temp[temp.length - 1] = val;

    arr = temp;
    return arr[arr.length - k];
  }
}
