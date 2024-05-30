package binary_search;

/*
Return the smallest character in letters that is lexicographically greater than target.
If such a character does not exist, return the first character in letters.
Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
 */

public class C744_FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters1 = {'c', 'f', 'j'};
        char[] letters2 = {'x', 'x', 'y', 'y'};
        System.out.println(nextGreatestLetter(letters1, 'c'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        if (letters[n - 1] <= target || letters[0] > target) return letters[0];

        int L = 0, R = n - 1;

        while (L < R) {
            int mid = (L + R)/2;

            if (letters[mid] <= target) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        return (letters[R] > target) ? letters[R] : letters[0];
    }

}
