package two_pointer;

/*
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C75_SortColors {
    public static void main(String[] args) {
        int arr[] = {2,0,1};

        sortColors(arr);
        System.out.println(Arrays.toString(arr));

    }

    // Dutch National Flag algorithm
    // 3 pointers
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int L = 0, R = n - 1, cur = 0;

        while (cur <= R) {
            if(nums[cur] == 2) {
                swap(nums, cur, R);
                R--;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, L);
                L++;
                cur++;
            }
        }
    }

    private static void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
