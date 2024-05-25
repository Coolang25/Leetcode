package sliding_window;

/*
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
*/

public class C76_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int[] arr = new int[128];
        int L = 0, R = 0;
        char[] s_arr = s.toCharArray();
        int n = s_arr.length;

        for (char i : t.toCharArray()) {
            arr[i]++;
        }

        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;


        while (R < n) {
            char cur = s_arr[R];
            if (--arr[cur] >= 0)
                count++;

            while(count == t.length()) {
                if (minLength > R - L + 1) {
                    minLength = R - L + 1;
                    start = L;
                }

                char leftChar = s_arr[L];
                if (++arr[leftChar] > 0)
                    count--;

                L++;
            }
            R++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

}
