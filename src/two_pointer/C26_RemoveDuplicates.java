package two_pointer;

import java.util.Arrays;

/*
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
*/

public class C26_RemoveDuplicates {
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,1,2,3,3};

        System.out.println(removeDuplicates(arr));

        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;

        int L = 1;
        int R = 1;

        while(R < nums.length) {
            if(nums[L-1] != nums[R]) {
                nums[L] = nums[R];
                L++;
            }
            R++;
        }

        return L;
    }
}
