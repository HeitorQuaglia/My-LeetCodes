import java.util.Stack;

public class ValidateParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                var c1 = stack.pop();
                if ((c1 == '(' && c != ')') ||
                    (c1 == '[' && c != ']') ||
                    (c1 == '{' && c != '}')
                ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
