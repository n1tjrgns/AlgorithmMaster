package programmers.kakaointernship;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;
//https://programmers.co.kr/learn/courses/30/lessons/60058
public class TransGualho {
    /*
    (와 )의 개수가 같으면 균형잡힌 괄호
    개수가 같으면서 짝도 맞는경우 올바른 괄호 문자열열    * */
    public String solution(String p) {
        //빈 문자열 -> 빈 문자열 반환
        // 문자열 p를 최초의 균형잡힌 문자열과(u) 나머지 균형잡힌 문자열로 분리(v)
        // u가 올바른 문자열이면 v를 다시 맨 위부터 실행.
        //u가 올바른 문자열이 아니면,
        // 빈 문자열에 첫 번째 문자로 ( 를 붙임
        // v를 붙임
        // )를 붙임
        // 가공한 u에 대해서 첫번째 문자와 마지막 문자를 제거, 나머지 문자열의 괄호 방향을 뒤집어서 이어 붙이기
        // 생성된 문자열 반환

        //스플릿하지말고 스트링으로 넘기자
        String answer = "";
        if(rightCheck(p)){ //변환할게 없으면
            return p; //바로 리턴
        }else{
            answer = divideUV(p); // u와 v로 나누기 시작
        }
        return answer;
    }

    // 올바른지 괄호인지 판단하는 메소드
    private boolean rightCheck(String p) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                stack.add(p.charAt(i));
            }else{
                if(stack.isEmpty()){
                    continue;
                }
                stack.pop();
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    // 문자가 들어오면 u, v 2개로 나누는 메소드
    private String divideUV(String p){
        if (p.equals("")) { //빈 문자열이 들어오면 빈문자열 리턴
            return "";
        }

        int divideIndex = divide(p);

        //잘라야하는 인덱스를 사용해서 자르기
        String u = p.substring(0, divideIndex);
        String v = p.substring(divideIndex);

        //u가 올바른 문자열이면 v를 다시 1부터 돌린다.
        if(rightCheck(u)){
            return u + divideUV(v);
        }else {
            //빈 문자열에 붙인다는게 그냥 아예 별개의 문자인가?
            String newStr = "("+divideUV(v)+")";
            u = u.substring(1, u.length()-1);
            u = reverse(u);
           return newStr + u;
        }
    }

    //잘라야 하는 인덱스를 반환
    private int divide(String p) {
        int left = 0;
        int right = 0;
        int i=0;
        for (i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            //계속 담다가 균형잡히면 그만
            if (left == right) {
                //그만 둔 시점의 인덱스 기억
                return i+1;
            }
        }
        return i;
    }

    private String reverse(String u) {



        StringBuilder sbU = new StringBuilder();
        // ())()(() -> ()()()
        // (()()) -> ()(())()

        for(int i=0; i<u.length(); i++){
            if(u.charAt(i)=='('){
                sbU.append(")");
            }else if(u.charAt(i)==')'){
                sbU.append("(");
            }
        }
        return sbU.toString();
    }

    //
    @Test
    public void 괄호체크() throws Exception{
        //given
        TransGualho t = new TransGualho();
        String p = ")(";
        String result = "()";
        //when
        //then
        Assert.assertEquals(t.solution(p), result);
    }
    @Test
    public void 괄호체크2() throws Exception{
        //given
        TransGualho t = new TransGualho();
        String p = "(()())()";
        String result = "(()())()";
        //when
        //then
        Assert.assertEquals(t.solution(p), result);
    }
    @Test
    public void 괄호체크3() throws Exception{
        //given
        TransGualho t = new TransGualho();
        String p = "()))((()";
        String result = "()(())()";
        //when
        //then
        Assert.assertEquals(t.solution(p), result);
    }
}