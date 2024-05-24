package sliding_window;

/*
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
*/

import java.util.HashMap;
import java.util.Map;

public class C567_PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[128];
        int L = 0, R = 0;
        char[] s1_arr = s1.toCharArray();
        char[] s2_arr = s2.toCharArray();
        int n = s2_arr.length;

        for (char i : s1_arr) {
            arr[i]++;
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        // ý tưởng tìm ra dãy con có độ dài ngắn nhất thỏa mãn số lượnng ký tự của s1 có trong dãy con = độ dài s1
        // so sánh độ dài dãy con với chiều dài s1

        while (R < n) {
            char cur = s2_arr[R];
            if (--arr[cur] >= 0)
                count++;

            while(count == s1_arr.length) {
                min = Math.min(min, R - L + 1);

                char leftChar = s2_arr[L];
                if (++arr[leftChar] > 0)
                    count--;

                L++;
            }
            R++;
        }

        return min == s1_arr.length;

    }

}
