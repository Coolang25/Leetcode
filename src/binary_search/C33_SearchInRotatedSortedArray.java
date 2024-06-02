package binary_search;

/*
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */

public class C33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while (L <= R) {
            int mid = L + (R - L)/2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[L] <= nums[mid]) {
                if (target >= nums[L] && target < nums[mid]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[R]) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }

        }

        return -1;
    }

}
