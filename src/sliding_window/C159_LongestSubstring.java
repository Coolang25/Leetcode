package sliding_window;

/*
Input: "eceba"
Output: 3
Explanation: "ece"
*/

import java.util.HashMap;
import java.util.Map;

public class C159_LongestSubstring {
    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        // base case
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n < 3) return n;

        // define pointer
        int L = 0, R = 0;

        // define table
        Map<Character, Integer> hm = new HashMap<>();

        // define maxLen
        int maxLen = 0;

        // find the max length substring 2 distinct char
        while (R < n) {
            hm.put(arr[R], hm.getOrDefault(arr[R], 0) + 1);

            while (hm.size() > 2) {
                hm.put(arr[L], hm.get(arr[L]) - 1);
                if (hm.get(arr[L]) == 0) {
                    hm.remove(arr[L]);
                }
                L++;
            }
            maxLen = Math.max(maxLen, (R - L + 1));
            R++;
        }

        return maxLen;
    }

}
