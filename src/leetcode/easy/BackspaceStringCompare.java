package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        //#이 나오면 앞의 글자를 지움
        //더이상 지울 글자가 없으면 공백 그대로 유지
        //최종 지운 결과가 같으면 true 다르면 false
        /*Stack<Character> stack = new Stack<>();
        for(char c1 : S.toCharArray()){
           if(c1 != '#'){
               stack.add(c1);
           }else{
               if(!stack.isEmpty()){
                   stack.pop();
               }
           }
        }

        Stack<Character> stack2 = new Stack<>();
        for(char c2 : T.toCharArray()){
            if(c2 != '#'){
                stack2.add(c2);
            }else{
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
        }

        return stack.equals(stack2);*/
        return calBackSpace(S).equals(calBackSpace(T));
    }

    private String calBackSpace(String t) {
        Stack<Character> stack = new Stack<>();
        for(char c1 : t.toCharArray()){
            if(c1 != '#'){
                stack.add(c1);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
                BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
            System.out.println(backspaceStringCompare.backspaceCompare("a##c","#a#c"));
        }
}
