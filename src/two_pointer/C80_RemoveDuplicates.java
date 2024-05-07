package two_pointer;

import java.util.Arrays;

/*
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
*/

public class C80_RemoveDuplicates {
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,1,2,3,3};

        System.out.println(removeDuplicates(arr));

        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;

        int L = 0;
        int R = 1;
        int count = 0;
        while (R < nums.length) {
            if ((nums[L] == nums[R]) && (count == 0)) {
                nums[++L] = nums[R];
                count++;
            } else if (nums[L] != nums[R]) {
                nums[++L] = nums[R];
                count = 0;
            }
            R++;

        }
        return L+1;


        // Cách 2
//        int j = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (j == 1 || nums[i] != nums[j - 2]) {
//                nums[j++] = nums[i];
//            }
//        }
//        return j;
    }
}
