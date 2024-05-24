package sliding_window;

/*
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with
two 'B's or vice versa.
*/

import java.util.HashMap;
import java.util.Map;

public class C424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        System.out.println(characterReplacement(s, 2));
    }

    public static int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int L = 0, R = 0;

        Map<Character, Integer> hm = new HashMap<>();
        // Dùng array thay thế
        // int[] arr = new int[26];
        // arr[s.charAt(r) - 'A']++;

        int maxLen = 0, mostFreq = 0;

        while (R < n) {
            hm.put(arr[R], hm.getOrDefault(arr[R], 0) + 1);
            mostFreq = Math.max(mostFreq, hm.get(arr[R]));

            // Shrink the window if we need to replace more than k char
            if((R - L + 1) - mostFreq > k) {
                hm.put(arr[L], hm.get(arr[L]) - 1);
                L++;
            }
            maxLen = Math.max(maxLen, (R - L + 1));
            R++;
        }

        return maxLen;


        // Rút gọn
//        int len = s.length();
//        int[] count = new int[26];
//        int start = 0, maxCount = 0, maxLength = 0;
//        for (int end = 0; end < len; end++) {
//            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
//            while (end - start + 1 - maxCount > k) {
//                count[s.charAt(start) - 'A']--;
//                start++;
//            }
//            maxLength = Math.max(maxLength, end - start + 1);
//        }
//        return maxLength;
    }

}
