package programmers.skillchecktest;

import java.util.Stack;

public class IronBar {

    public int solution(String arrangement) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<arrangement.length(); i++){
            if(arrangement.charAt(i) == '('){
                stack.add(arrangement.charAt(i));
            }else{
                stack.pop();
                if(arrangement.charAt(i-1) == '('){
                    answer = answer + stack.size();
                }else{
                    answer = answer + 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        IronBar i = new IronBar();
        String s = "()(((()())(())()))(())";
        System.out.println(i.solution(s));
    }
}
