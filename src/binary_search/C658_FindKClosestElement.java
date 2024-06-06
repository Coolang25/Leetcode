package binary_search;

/*
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class C658_FindKClosestElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(findClosestElements(nums, 4, 3));
    }

//    case 1: x - A[mid] < A[mid + k] - x, need to move window go left
//-------x----A[mid]-----------------A[mid + k]----------
//
//case 2: x - A[mid] < A[mid + k] - x, need to move window go left again
//-------A[mid]----x-----------------A[mid + k]----------
//
//case 3: x - A[mid] > A[mid + k] - x, need to move window go right
//-------A[mid]------------------x---A[mid + k]----------
//
//case 4: x - A[mid] > A[mid + k] - x, need to move window go right
//-------A[mid]---------------------A[mid + k]----x------

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int L = 0, R = arr.length - k;

        while (L < R) {
            int mid = (L + R)/2;

            if (x - arr[mid] > arr[mid + k] - x) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        List<Integer> res = new LinkedList<>();

        for (int i = L; i < L + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

}
