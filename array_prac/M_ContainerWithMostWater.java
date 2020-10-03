package array_prac;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * E.g:
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 7(min height) * 7(width) = 49
 */
public class M_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int start = 0, end = height.length - 1, max = 0;
        while (start < end) {
            // area = Min(height) * (width)
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) { // adjust the pointer
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 2, 4, 3 }));
    }
}
