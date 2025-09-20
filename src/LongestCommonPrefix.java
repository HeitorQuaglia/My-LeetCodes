import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"","b"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        int lowestStringLen = getLowestStrLen(strs);
        if (lowestStringLen == 0) return "";

        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < lowestStringLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    flag = true;
                    break;
                }
            }
            if (flag) return result.toString();
            result.append(strs[0].charAt(i));
        }

        return result.toString();
    }

    static int getLowestStrLen(String[] strs) {
        int[] lens = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            lens[i] = strs[i].length();
        }

        Arrays.sort(lens);

        return lens[0];
    }
}
