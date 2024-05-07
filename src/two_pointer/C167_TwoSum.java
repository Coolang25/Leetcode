package two_pointer;

import java.util.Arrays;

/*
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
    Explanation: The sum of 2 and 7 is 9.
    Therefore, index1 = 1, index2 = 2.
    We return [1, 2].
*/

public class C167_TwoSum {
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }else if (sum < target) {
                left++;
            }else {
                right--;
            }

        }

        return new int[] {-1, -1};
    }
}
