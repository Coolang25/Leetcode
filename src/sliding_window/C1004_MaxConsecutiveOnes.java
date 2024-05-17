package sliding_window;

/*
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*/

public class C1004_MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(arr, 2));
    }

    public static int longestOnes(int[] nums, int k) {

        int n = nums.length;
        if (n < 2 && k > 0) return n;

        int L = 0, R = 0;
        int maxLen = 0, counter = 0;

        while (R < n) {
            if (nums[R] == 0) {
                counter++;
            }
            while (counter > k) {
                if (nums[L] == 0) {
                    counter--;
                }
                L++;
            }

            maxLen = Math.max(maxLen, R - L + 1);

            R++;
        }

        return maxLen;



        // rút gọn
//        int i = 0, j;
//        for (j = 0; j < A.length; ++j) {
//            if (A[j] == 0) K--;
//            if (K < 0 && A[i++] == 0) K++;
//        }
//        return j - i;
    }

}
