import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        var s1 = "abcabcbb";
        var s2 = "bbbbb";
        var s3 = "pwwkew";
        var s4 = " ";
        var s5 = "au";

        var r1 = lengthOfLongestSubstring(s1);
        var r2 = lengthOfLongestSubstring(s2);
        var r3 = lengthOfLongestSubstring(s3);
        var r4 = lengthOfLongestSubstring(s4);
        var r5 = lengthOfLongestSubstring(s5);

        System.out.println(r1 == 3);
        System.out.println(r2 == 1);
        System.out.println(r3 == 3);
        System.out.println(r4 == 1);
        System.out.println(r5 == 2);

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        var map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            var charAtRight = s.charAt(right);
            var windowSize = right - left + 1;
            map.put(charAtRight, map.getOrDefault(charAtRight, 0) + 1);

            if (map.size() == windowSize) {
                max = Math.max(max, windowSize);
                right++;
            } else if (map.size() < windowSize) {
                while (map.size() < windowSize) {
                    var charAtLeft = s.charAt(left);
                    var count = map.get(charAtLeft);

                    if (count == 1) {
                        map.remove(charAtLeft);
                    } else {
                        map.put(charAtLeft, count - 1);
                    }
                    left++;
                    windowSize = right - left + 1;
                }
                right++;
            }
        }

        return max;
    }
}
