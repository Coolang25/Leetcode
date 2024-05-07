package two_pointer;

/*
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class C763_PartitionLabel {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));

    }

    public static List<Integer> partitionLabels(String s) {
        char[] arr = s.toCharArray();
        int[] lastPosition = new int[128];
        for (int i = 0; i < arr.length; i++) {
            char curChar = arr[i];
            lastPosition[curChar] = i;
        }

        int L = 0, R = 0, index = 0, n = arr.length;

        List<Integer> result = new LinkedList<>();

        while (index < n) {
            char cur = arr[index];
            R = Math.max(lastPosition[cur], R);
            if (R == index) {
                result.add(R - L + 1);
                R++;
                L = R;
            }
            index++;
        }

        return result;
    }
}
