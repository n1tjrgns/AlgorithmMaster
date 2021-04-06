package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/generate-parentheses/
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//주어진 숫자 만큼의 괄호 쌍으로 만들 수 있는 조합 모두 만들
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();


        backtrack(result, new char[n*2], 0,n*2);
        return  result;
    }

    private void backtrack(List<String> result, char[] temp, int idx, int length) {
        //길이를 6으로 선언해놔서 무조건 타버리
        if (idx == temp.length){
            //괄호가 쌍이 만족하는지 유효성 검사 필요
            if (isValid(temp)){
                result.add(new String(temp));
                System.out.println("result = " + result);
            }

        }else{
            //괄호로 채우기
            temp[idx] = '(';
            backtrack(result, temp, idx+1, length);
            temp[idx] = ')';
            backtrack(result, temp, idx+1, length);
        }
    }

    //이건 순
    private boolean isValid(char[] temp) {
        Stack<Character> stack = new Stack<>();
        for (char c: temp){
            if (c == '(') stack.add(c);
            else {
                if (!stack.isEmpty()) stack.pop();
                else return false;
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
    }
}
