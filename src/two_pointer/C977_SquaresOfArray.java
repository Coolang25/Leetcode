package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
*/

public class C977_SquaresOfArray {
    public static void main(String[] args) {
        int arr[] = {-6,-4,-2,-1,0,9,10};

        System.out.println(Arrays.toString(sortedSquares(arr)));

    }

    public static int[] sortedSquares(int[] nums) {

        int L = 0;
        int R = nums.length - 1;
        int[] result = new int[nums.length];
        int index = R;

        while (index >= 0) {
            int leftValue = nums[L]*nums[L];
            int rightValue = nums[R]*nums[R];

            if (leftValue < rightValue) {
                result[index] = rightValue;
                R--;
                index--;
            } else {
                result[index] = leftValue;
                L++;
                index--;
            }
        }


        return result;
    }
}
