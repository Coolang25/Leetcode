package two_pointer;

/*

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C259_ThreeSumSmaller {
    public static void main(String[] args) {
        int arr[] = {-2,0,1,3};

        System.out.println(threeSumSmaller(arr, 2));

    }

    public static int threeSumSmaller(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);

        int count = 0, n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int L = i + 1;
            int R = n - 1;

            while (L < R) {
                int curSum = nums[i] + nums[L] + nums[R];

                if (curSum < target) {
                    count+= R - L;
                    L++;
                } else {
                    R--;
                }
            }
        }
        return count;
    }
}
