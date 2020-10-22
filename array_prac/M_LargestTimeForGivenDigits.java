package array_prac;

/**
 * Given an array arr of 4 digits, find the latest 24-hour time that can be made
 * using each digit exactly once.
 * 
 * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM
 * is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is
 * 23:59.
 * 
 * Return the latest 24-hour time in "HH:MM" format. If no valid time can be
 * made, return an empty string.
 * 
 * Constraints:
 * arr.length == 4
 * 0 <= arr[i] <= 9
 */
public class M_LargestTimeForGivenDigits {

    /**
     * Runtime: 9 ms, faster than 76.18% of Java online submissions for Largest Time for Given Digits.
     * Memory Usage: 38.9 MB, less than 6.00% of Java online submissions for Largest Time for Given Digits.
     * 
     * Idea:
     * 
     * Permute given four digits and validate the result, then save the largest time
     * 
     * Runtime: O(1), bc the input size is fixed
     * Space: O(1), bc permute array in-place + only save max hour & time
     * 
     */
    static String largestTimeFromDigits(int[] arr) {
        int[] max = { -1, -1 };
        permuteAndUpdateMaxTime(arr, max, 0);

        if (max[0] == -1 && max[1] == -1)
            return "";

        return new StringBuilder()
            .append(max[0] > 9 ? "" : "0")
            .append(max[0]).append(":")
            .append(max[1] > 9 ? "" : "0")
            .append(max[1]).toString();
    }

    static void permuteAndUpdateMaxTime(int[] arr, int[] max, int i) {
        if (i == arr.length - 1) {
            int hour = Integer.parseInt(arr[0] + "" + arr[1]);
            int time = Integer.parseInt(arr[2] + "" + arr[3]);

            if (hour < 24 && time < 60) {
                if (hour > max[0] || (hour == max[0] && time > max[1])) {
                    max[0] = hour;
                    max[1] = time;
                }
            }

            return;
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            permuteAndUpdateMaxTime(arr, max, i + 1);
            swap(arr, i, j);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1,2,3,4})); //"23:41"
        System.out.println(largestTimeFromDigits(new int[]{5,5,5,5})); // ""
        System.out.println(largestTimeFromDigits(new int[]{0,0,0,0})); //"00:00"
        System.out.println(largestTimeFromDigits(new int[]{0,0,1,0})); //"10:00"
    }
}
