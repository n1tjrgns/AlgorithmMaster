package inflearn.stringarray.sec4QueStack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> que = new Stack<>();
        char[] toCharArray = s.toCharArray();
        for (char c : toCharArray) {
            if ('(' == c || '[' == c || '{' ==c ){
                que.add(c);
            }else{
                if (que.isEmpty()){
                    return false;
                }else if (c==')' && que.pop() != '('){
                    return false;
                }else if (c==']' && que.pop() != '['){
                    return false;
                }else if (c=='}' && que.pop() != '{'){
                    return false;
                }
            }
        }

        return que.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("([)]"));
    }
}
