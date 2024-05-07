package two_pointer;

/*
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C16_ThreeSumClosest {
    public static void main(String[] args) {
        int arr[] = {-1,2,1,-4};

        System.out.println(threeSumClosest(arr, 1));

    }

    public static int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];;

        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
