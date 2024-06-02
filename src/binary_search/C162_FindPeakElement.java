package binary_search;

/*
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2,
or index number 5 where the peak element is 6.
*/

public class C162_FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int L = 0, R = n - 1;

        while (L < R) {
            int mid = (L + R)/2;

            if (nums[mid] < nums[mid + 1]) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        return L;
    }

}
