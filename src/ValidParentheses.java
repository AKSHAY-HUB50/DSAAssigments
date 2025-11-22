import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');



        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mappings.containsKey(c)) {

                char requiredOpenBracket = mappings.get(c);

                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != requiredOpenBracket) {
                    return false;
                }

            }

            else {
                 stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses checker = new ValidParentheses();


        System.out.println("() is valid: " + checker.isValid("()"));
        System.out.println("()[]{} is valid: " + checker.isValid("()[]{}"));
        System.out.println("{[]} is valid: " + checker.isValid("{[]}"));


        System.out.println("(] is valid: " + checker.isValid("(]"));
        System.out.println("([)] is valid: " + checker.isValid("([)]"));
        System.out.println("{ is valid: " + checker.isValid("{"));
    }
}