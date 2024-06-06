package binary_search;

/*
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
 */

import java.util.Arrays;

public class C34_FindFirstAndLastInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums.length == 0) return res;

        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);

        return res;
    }

    private static int findLeft(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while (L + 1 < R) {
            int mid = L + (R - L)/2;

            if (nums[mid] < target) {
                L = mid;
            } else {
                R = mid;
            }
        }
        if (nums[L] == target) return L;
        if (nums[R] == target) return R;
        return  -1;
    }

    private static int findRight(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while (L + 1 < R) {
            int mid = L + (R - L)/2;

            if (nums[mid] <= target) {
                L = mid;
            } else {
                R = mid;
            }
        }
        if (nums[R] == target) return R;
        if (nums[L] == target) return L;
        return  -1;
    }

//    public int[] searchRange(int[] nums, int target) {
//        int[] result = {-1, -1};
//        int left = binarySearch(nums, target, true);
//        int right = binarySearch(nums, target, false);
//        result[0] = left;
//        result[1] = right;
//        return result;
//    }
//
//    private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
//        int left = 0;
//        int right = nums.length - 1;
//        int idx = -1;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//
//            if (nums[mid] > target) {
//                right = mid - 1;
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                idx = mid;
//                if (isSearchingLeft) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//        }
//
//        return idx;
//    }

}
