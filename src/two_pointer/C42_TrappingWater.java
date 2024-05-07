package two_pointer;

/*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C42_TrappingWater {
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(arr));

    }

    public static int trap(int[] height) {
        int max = 0, n = height.length;
        for (int i = 0; i < n; i++) {
            if (height[max] < height[i]) {
                max = i;
            }
        }

        int sum = 0;
        int leftMax = 0, rightMax = n - 1;

        for (int i = 0; i < max; i++) {
            if (height[leftMax] < height[i]) {
                leftMax = i;
            }

            sum += Math.min(height[leftMax], height[max]) - height[i];
        }

        for (int i = n - 1; i > max; i--) {
            if (height[rightMax] < height[i]) {
                rightMax = i;
            }

            sum += Math.min(height[rightMax], height[max]) - height[i];
        }

        return sum;
    }

    // hướng tiếp cân theo qui hoạch động
//    int n = height.length;
//        if (n == 0) return 0;
//
//    int[] left = new int[n];
//    int[] right = new int[n];
//    int storedWater = 0;
//
//    // Fill left array
//    left[0] = height[0];
//        for (int i = 1; i < n; i++) {
//        left[i] = Math.max(left[i - 1], height[i]);
//    }
//
//    // Fill right array
//    right[n - 1] = height[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//        right[i] = Math.max(right[i + 1], height[i]);
//    }
//
//    // Calculate trapped water
//        for (int i = 0; i < n; i++) {
//        int minHeight = Math.min(left[i], right[i]);
//        storedWater += minHeight - height[i];
//    }
//
//        return storedWater;
}
