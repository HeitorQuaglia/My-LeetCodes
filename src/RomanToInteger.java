import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static Map<String, Integer> values = new HashMap<>();

    public static void main(String[] args) {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);

        var string = "MCMXCIV";
        var result = romanToInt(string);

        System.out.println(result);
    }

    public static int romanToInt(String s) {
        var len = s.length();
        var total = values.get(s.charAt(len - 1) + "");

        for  (int i = len - 2; i >= 0; i--) {
            var current = values.get(s.charAt(i) + "");
            var previous = values.get(s.charAt(i + 1) + "");
            if (current >= previous ) {
                total += current;
            }
            else {
                total -= previous;
            }
        }

        return total;
    }
}