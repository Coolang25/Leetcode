package binary_search;

/*
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */

public class C153_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        if (nums[L] < nums[R]) return nums[L];

        while (L + 1 < R) {
            int mid = L + (R - L)/2;
            if (nums[mid] > nums[R]) {
                L = mid;
            } else {
                R = mid;
            }
        }

        return Math.min(nums[L], nums[R]);
    }

}
