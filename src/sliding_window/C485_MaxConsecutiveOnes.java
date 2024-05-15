package sliding_window;

/*
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
*/

import java.util.HashMap;
import java.util.Map;

public class C485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0, counter = 0;

        for (int i : nums) {
            if (i == 0) {
                counter = 0;
            } else {
                counter++;
                maxLen = Math.max(maxLen, counter);
            }
        }

        return maxLen;
    }

}
