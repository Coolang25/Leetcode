package two_pointer;

import java.util.Arrays;

/*
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
*/

public class C11_ContainerWater {
    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int L = 0, R = n - 1, maxArea = Integer.MIN_VALUE;

        while (L < R) {
            int area = (R - L) * Math.min(height[L], height[R]);
            maxArea = Math.max(maxArea, area);
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return maxArea;
    }
}
