package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*
Example 2:
Input: nums = [0]
Output: [0]
* */

public class C283_MoveZeroes {
    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] nums) {
        // Cách 1
//        int[] result = new int[nums.length];
//        int index = 0;
//        for(int value : nums) {
//            if(value != 0) {
//                result[index] = value;
//                index++;
//            }
//        }
//        System.out.println(Arrays.toString(result));

        // Cách 2
        int n = nums.length;
        if (n < 2) return;

        int L = 0, R = 1;

        while (R < n) {
            if (nums[L] != 0) {
                L++;
            } else if (nums[R] == 0) {
                R++;
            } else {
                int temp = nums[R];
                nums[R] = nums[L];
                nums[L] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));

        // Biến tướng của 2 con trỏ (Khi đổi chỗ xong thì left + 1 luôn bằng 0 nên không cần quan tâm left)
//        public void moveZeroes(int[] nums) {
//            int left = 0;
//
//            for (int right = 0; right < nums.length; right++) {
//                if (nums[right] != 0) {
//                    int temp = nums[right];
//                    nums[right] = nums[left];
//                    nums[left] = temp;
//                    left++;
//                }
//            }
//        }

        // Cách 3: snowball cách tiếp cận giống cửa sổ trượt
//        int snowBallSize = 0;
//        for (int i=0;i<nums.length;i++){
//            if (nums[i]==0){
//                snowBallSize++;
//            }
//            else if (snowBallSize > 0) {
//                int t = nums[i];
//                nums[i]=0;
//                nums[i-snowBallSize]=t;
//            }
//        }
    }
}
