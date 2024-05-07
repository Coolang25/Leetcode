package two_pointer;

/*
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
*/

public class Test {
    public static void main(String[] args) {
        String arr[] = {"A", "B", "A", "C", "A", "B"};
        System.out.println(ArrayChallenge(arr));
    }

    public static String ArrayChallenge(String[] strArr) {
        // code goes here
        int n = strArr.length;
        // create an array with default value = -1
        int[] position = new int[26];
        for(int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        for(int i = 0; i < n; i++) {
            int curChar = strArr[i].charAt(0);
            position[curChar - 65] = i;
        }

        char[] charList = new char[26];
        for(int i = 0; i < 26; i++) {
            if (position[i] != -1) {
                charList[position[i]] = (char)(i + 65);
            }
        }

        String a = new String();
        for(char value : charList) {
            if(value != '\u0000') {
                a+=value;
            }
        }
        System.out.println(a.length());

        return a;
    }
}
