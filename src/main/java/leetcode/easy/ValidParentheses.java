package leetcode.easy;

import java.util.Stack;

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true*/
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }else if (s.charAt(i) == ')' && stack.pop() != '('){
                    return false;
                }else if (s.charAt(i) == ']' && stack.pop() != '['){
                    return false;
                }else if (s.charAt(i) == '}' && stack.pop() != '{'){
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("()[]{}"));
    }
}
