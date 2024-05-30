package binary_search;

/*
Input: nums = [2,2,2,0,1]
Output: 0
 */

public class C154_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {10,1,10,10,10};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        if (nums[L] < nums[R]) return nums[L];

        while (L + 1 < R) {
            int mid = L + (R - L)/2;
            if (nums[mid] > nums[R]) {
                L = mid;
            } else if (nums[mid] < nums[R]){
                R = mid;
            } else {
                R--;
            }
        }

        return Math.min(nums[L], nums[R]);
    }

}
